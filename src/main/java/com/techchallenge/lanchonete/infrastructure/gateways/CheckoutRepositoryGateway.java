package com.techchallenge.lanchonete.infrastructure.gateways;

import com.techchallenge.lanchonete.adapters.persistence.repository.checkout.SpringCheckoutRepository;
import com.techchallenge.lanchonete.application.domain.Checkout;
import com.techchallenge.lanchonete.application.dto.CheckoutDTO;
import com.techchallenge.lanchonete.application.mapper.checkout.CheckoutEntityMapper;
import com.techchallenge.lanchonete.application.port.incoming.checkout.CheckoutUseCase;

public class CheckoutRepositoryGateway implements CheckoutUseCase {
    private final SpringCheckoutRepository springCheckoutRepository;
    private final CheckoutEntityMapper checkoutEntityMapper;

    public CheckoutRepositoryGateway(SpringCheckoutRepository springCheckoutRepository, CheckoutEntityMapper checkoutEntityMapper) {
        this.springCheckoutRepository = springCheckoutRepository;
        this.checkoutEntityMapper = checkoutEntityMapper;
    }

    @Override
    public void criar(Checkout checkout) {

    }

    @Override
    public CheckoutDTO buscar(Long id) {
        return null;
    }
}
