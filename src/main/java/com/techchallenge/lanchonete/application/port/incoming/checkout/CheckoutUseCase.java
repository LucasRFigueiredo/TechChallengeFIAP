package com.techchallenge.lanchonete.application.port.incoming.checkout;

import com.techchallenge.lanchonete.application.dto.CheckoutDTO;
import com.techchallenge.lanchonete.application.dto.PedidoDTO;

public interface CheckoutUseCase {
    void criar(PedidoDTO pedidoDTO);

    CheckoutDTO buscar(Long id);
}
