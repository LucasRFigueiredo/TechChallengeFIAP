package com.techchallenge.lanchonete.application.usecases;

import com.techchallenge.lanchonete.application.dto.CheckoutDTO;
import com.techchallenge.lanchonete.application.gateways.checkout.CheckoutUseCase;
import com.techchallenge.lanchonete.domain.Checkout;
import com.techchallenge.lanchonete.domain.Pedido;
import com.techchallenge.lanchonete.domain.Produto;
import com.techchallenge.lanchonete.infrastructure.mapper.checkout.CheckoutMapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CheckoutServiceImpl {
    private final CheckoutUseCase checkoutUseCase;
    private final CheckoutMapper checkoutMapper;

    public CheckoutServiceImpl(CheckoutUseCase checkoutUseCase, CheckoutMapper checkoutMapper) {
        this.checkoutUseCase = checkoutUseCase;
        this.checkoutMapper = checkoutMapper;
        //iniciarTarefaAtualizacaoStatus();
    }

    public void criar(Pedido pedido) {
        BigDecimal total = new BigDecimal(0);
        Checkout checkout = new Checkout();
        checkout.setPedido(pedido);
        for (Produto produto : checkout.getPedido().getItens()) {
            total = total.add(BigDecimal.valueOf(produto.getPreco()));
        }
        checkout.setTotal(total);
        checkout.setPagamento("Aguardando pagamento");
        checkout.setStatus("Aguardando pagamento");
        checkoutUseCase.criar(checkout);
        iniciarTarefaAtualizacaoStatus();
    }


    public CheckoutDTO buscar(Long id) {
        return checkoutMapper.checkoutToCheckoutDTO(checkoutUseCase.buscar(id));
    }

    private void iniciarTarefaAtualizacaoStatus() {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Executando tarefa de atualização de status...");
            atualizarStatus();
        }, 0, 1, TimeUnit.MINUTES);
    }

    private void atualizarStatus() {
        List<Checkout> checkoutsAprovados = checkoutUseCase.buscarPorStatusPagamento("Aprovado");
        System.out.println("to aqui");
        for (Checkout checkout : checkoutsAprovados) {
            String statusAtual = checkout.getStatus();

            if ("Em preparação".equals(statusAtual)) {
                checkout.setStatus("Pronto");
            } else if ("Aguardando pagamento".equals(statusAtual)) {
                checkout.setStatus("Em preparação");
            }
            checkoutUseCase.atualizarStatus(checkout);
        }
    }
}
