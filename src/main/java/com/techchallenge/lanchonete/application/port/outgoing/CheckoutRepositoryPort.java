package com.techchallenge.lanchonete.application.port.outgoing;

import com.techchallenge.lanchonete.application.domain.Checkout;

import java.util.List;

public interface CheckoutRepositoryPort {
    void salvar(Checkout checkout);

    List<Checkout> listar();

    Checkout buscar(Long id);
}
