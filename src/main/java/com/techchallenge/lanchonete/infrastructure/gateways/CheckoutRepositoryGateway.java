package com.techchallenge.lanchonete.infrastructure.gateways;

import com.techchallenge.lanchonete.infrastructure.persistence.entity.CheckoutEntity;
import com.techchallenge.lanchonete.infrastructure.persistence.repository.checkout.SpringCheckoutRepository;
import com.techchallenge.lanchonete.domain.Checkout;
import com.techchallenge.lanchonete.infrastructure.mapper.checkout.CheckoutEntityMapper;
import com.techchallenge.lanchonete.application.gateways.checkout.CheckoutUseCase;
import jakarta.persistence.EntityManager;

import java.util.Objects;
import java.util.Optional;

public class CheckoutRepositoryGateway implements CheckoutUseCase {
    private final SpringCheckoutRepository springCheckoutRepository;
    private final CheckoutEntityMapper checkoutEntityMapper;
    private final EntityManager entityManager;

    public CheckoutRepositoryGateway(SpringCheckoutRepository springCheckoutRepository, CheckoutEntityMapper checkoutEntityMapper, EntityManager entityManager) {
        this.springCheckoutRepository = springCheckoutRepository;
        this.checkoutEntityMapper = checkoutEntityMapper;
        this.entityManager = entityManager;
    }

    @Override
    public void criar(Checkout checkout) {
        CheckoutEntity checkoutEntity;
        if (Objects.isNull(checkout.getId())) {
            checkoutEntity = checkoutEntityMapper.checkoutToCheckoutEntity(checkout);
        } else {
            checkoutEntity = this.springCheckoutRepository.findById(checkout.getId()).get();
            checkoutEntity = checkoutEntityMapper.checkoutToCheckoutEntity(checkout);
        }
        checkoutEntity.setPedido(entityManager.merge(checkoutEntity.getPedido()));
        checkoutEntity = entityManager.merge(checkoutEntity);
        this.springCheckoutRepository.save(checkoutEntity);
    }

    @Override
    public Checkout buscar(Long id) {
        Optional<CheckoutEntity> byId = springCheckoutRepository.findById(id);
        if (byId.isPresent()) {
            return checkoutEntityMapper.checkoutEntityToCheckout(byId.get());
        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }
}
