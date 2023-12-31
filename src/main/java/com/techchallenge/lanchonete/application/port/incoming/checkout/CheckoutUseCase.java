package com.techchallenge.lanchonete.application.port.incoming.checkout;

import com.techchallenge.lanchonete.application.domain.Pedido;
import com.techchallenge.lanchonete.application.dto.CheckoutDTO;

public interface CheckoutUseCase {
    void criar(Pedido pedido);

    CheckoutDTO buscar(Long id);
}
