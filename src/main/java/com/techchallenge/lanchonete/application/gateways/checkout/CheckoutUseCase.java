package com.techchallenge.lanchonete.application.gateways.checkout;

import com.techchallenge.lanchonete.domain.Checkout;

public interface CheckoutUseCase {
    void criar(Checkout checkout);

    Checkout buscar(Long id);
}
