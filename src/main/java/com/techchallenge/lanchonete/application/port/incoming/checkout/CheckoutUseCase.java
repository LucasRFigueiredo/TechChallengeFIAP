package com.techchallenge.lanchonete.application.port.incoming.checkout;

import com.techchallenge.lanchonete.application.domain.Checkout;

public interface CheckoutUseCase {
    void criar(Checkout checkout);

    Checkout buscar(Long id);
}
