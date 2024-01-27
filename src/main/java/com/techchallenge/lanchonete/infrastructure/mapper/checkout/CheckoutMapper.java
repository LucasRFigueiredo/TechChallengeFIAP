package com.techchallenge.lanchonete.infrastructure.mapper.checkout;

import com.techchallenge.lanchonete.domain.Checkout;
import com.techchallenge.lanchonete.application.dto.CheckoutDTO;
import com.techchallenge.lanchonete.infrastructure.mapper.pedido.PedidoMapper;
import org.springframework.stereotype.Component;

@Component
public class CheckoutMapper {
    public static CheckoutDTO checkoutToCheckoutDTO(Checkout checkout) {
        CheckoutDTO checkoutDTO = new CheckoutDTO();
        checkoutDTO.setPedido(PedidoMapper.pedidoToPedidoDTO(checkout.getPedido()));
        checkoutDTO.setTotal(checkout.getTotal());
        return checkoutDTO;
    }
}