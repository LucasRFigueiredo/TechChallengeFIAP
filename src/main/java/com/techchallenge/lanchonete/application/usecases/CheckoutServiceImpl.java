package com.techchallenge.lanchonete.application.usecases;

import com.techchallenge.lanchonete.domain.Checkout;
import com.techchallenge.lanchonete.domain.Pedido;
import com.techchallenge.lanchonete.domain.Produto;
import com.techchallenge.lanchonete.application.dto.CheckoutDTO;
import com.techchallenge.lanchonete.infrastructure.mapper.checkout.CheckoutMapper;
import com.techchallenge.lanchonete.application.gateways.checkout.CheckoutUseCase;

import java.math.BigDecimal;

public class CheckoutServiceImpl {
    private final CheckoutUseCase checkoutUseCase;
    private final CheckoutMapper checkoutMapper;

    public CheckoutServiceImpl(CheckoutUseCase checkoutUseCase, CheckoutMapper checkoutMapper) {
        this.checkoutUseCase = checkoutUseCase;
        this.checkoutMapper = checkoutMapper;
    }

    public void criar(Pedido pedido) {
        BigDecimal total = new BigDecimal(0);
        Checkout checkout = new Checkout();
        checkout.setPedido(pedido);
        for (Produto produto : checkout.getPedido().getItens()) {
            total = total.add(BigDecimal.valueOf(produto.getPreco()));
        }
        checkout.setTotal(total);
        checkoutUseCase.criar(checkout);
    }


    public CheckoutDTO buscar(Long id) {
        return checkoutMapper.checkoutToCheckoutDTO(checkoutUseCase.buscar(id));
    }
}
