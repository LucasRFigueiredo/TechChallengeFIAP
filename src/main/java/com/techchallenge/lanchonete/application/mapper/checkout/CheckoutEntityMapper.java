package com.techchallenge.lanchonete.application.mapper.checkout;

import com.techchallenge.lanchonete.adapters.persistence.entity.CheckoutEntity;
import com.techchallenge.lanchonete.application.domain.Checkout;
import com.techchallenge.lanchonete.application.mapper.pedido.PedidoEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class CheckoutEntityMapper {
    public static CheckoutEntity checkoutToCheckoutEntity(Checkout checkout) {
        CheckoutEntity checkoutEntity = new CheckoutEntity();
        checkoutEntity.setPedido(PedidoEntityMapper.pedidoToPedidoEntity(checkout.getPedido()));
        checkoutEntity.setTotal(checkout.getTotal());
        checkoutEntity.setId(checkout.getId());
        return checkoutEntity;
    }

    public static Checkout checkoutEntityToCheckout(CheckoutEntity checkoutEntity) {
        Checkout checkout = new Checkout();
        checkout.setPedido(PedidoEntityMapper.pedidoEntityToPedido(checkoutEntity.getPedido()));
        checkout.setTotal(checkoutEntity.getTotal());
        checkout.setId(checkoutEntity.getId());
        return checkout;
    }
}
