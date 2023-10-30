package com.techchallenge.lanchonete.application.service;

import com.techchallenge.lanchonete.application.domain.Checkout;
import com.techchallenge.lanchonete.application.domain.Pedido;
import com.techchallenge.lanchonete.application.domain.Produto;
import com.techchallenge.lanchonete.application.dto.CheckoutDTO;
import com.techchallenge.lanchonete.application.mapper.checkout.CheckoutMapper;
import com.techchallenge.lanchonete.application.port.incoming.checkout.CheckoutUseCase;
import com.techchallenge.lanchonete.application.port.outgoing.CheckoutRepositoryPort;
import com.techchallenge.lanchonete.application.port.outgoing.PedidoRepositoryPort;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class CheckoutServiceImpl implements CheckoutUseCase {
    private final CheckoutMapper checkoutMapper;
    private final PedidoRepositoryPort pedidoRepository;
    private final CheckoutRepositoryPort checkoutRepositoryPort;

    @Override
    public void criar(Pedido pedido) {
        BigDecimal total = new BigDecimal(0);
        Checkout checkout = new Checkout();
        checkout.setPedido(pedido);
        for (Produto produto : checkout.getPedido().getItens()) {
            total = total.add(BigDecimal.valueOf(produto.getPreco()));
        }
        checkout.setTotal(total);
        checkoutRepositoryPort.salvar(checkout);
    }

    @Override
    public CheckoutDTO buscar(Long id) {
        return checkoutMapper.checkoutToCheckoutDTO(checkoutRepositoryPort.buscar(id));
    }
}
