package com.techchallenge.lanchonete.infrastructure.mapper.checkout;

import com.techchallenge.lanchonete.domain.Checkout;
import com.techchallenge.lanchonete.infrastructure.mapper.pedido.PedidoEntityMapper;
import com.techchallenge.lanchonete.infrastructure.persistence.entity.CheckoutEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class CheckoutEntityMapper {
    public static CheckoutEntity checkoutToCheckoutEntity(Checkout checkout) {
        CheckoutEntity checkoutEntity = new CheckoutEntity();
        checkoutEntity.setPedido(PedidoEntityMapper.pedidoToPedidoEntity(checkout.getPedido()));
        checkoutEntity.setTotal(checkout.getTotal());
        checkoutEntity.setId(checkout.getId());
        checkoutEntity.setPagamento(checkout.getPagamento());
        checkoutEntity.setStatus(checkout.getStatus());
        return checkoutEntity;
    }

    public static Checkout checkoutEntityToCheckout(CheckoutEntity checkoutEntity) {
        Checkout checkout = new Checkout();
        checkout.setPedido(PedidoEntityMapper.pedidoEntityToPedido(checkoutEntity.getPedido()));
        checkout.setTotal(checkoutEntity.getTotal());
        checkout.setId(checkoutEntity.getId());
        checkout.setPagamento(checkoutEntity.getPagamento());
        checkout.setStatus(checkoutEntity.getStatus());
        return checkout;
    }

    public static CheckoutEntity updateCheckoutEntityPagamento(Checkout checkout, CheckoutEntity checkoutEntity) {
        if (!Objects.isNull(checkout.getPagamento())) {
            checkoutEntity.setPagamento(checkout.getPagamento());
        }
        return checkoutEntity;
    }

    public static CheckoutEntity updateCheckoutEntityStatus(Checkout checkout, CheckoutEntity checkoutEntity) {
        if (!Objects.isNull(checkout.getStatus())) {
            checkoutEntity.setStatus(checkout.getStatus());
        }
        return checkoutEntity;
    }

    public static List<Checkout> checkoutEntitiesToCheckouts(List<CheckoutEntity> checkoutEntities) {
        if (!checkoutEntities.isEmpty()) {
            List<Checkout> checkouts = new ArrayList<>();
            for (CheckoutEntity checkoutEntity : checkoutEntities) {
                Checkout checkout = new Checkout();
                checkout.setId(checkoutEntity.getId());
                checkout.setPedido(PedidoEntityMapper.pedidoEntityToPedido(checkoutEntity.getPedido()));
                checkout.setTotal(checkoutEntity.getTotal());
                checkout.setPagamento(checkoutEntity.getPagamento());
                checkout.setStatus(checkoutEntity.getStatus());
                checkouts.add(checkout);
            }
            return checkouts;
        }
        return null;
    }
}
