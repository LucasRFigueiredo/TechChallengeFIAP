package com.techchallenge.lanchonete.adapters.persistence.repository.checkout;

import com.techchallenge.lanchonete.adapters.persistence.entity.CheckoutEntity;
import com.techchallenge.lanchonete.application.domain.Checkout;
import com.techchallenge.lanchonete.application.mapper.checkout.CheckoutEntityMapper;
import com.techchallenge.lanchonete.application.port.outgoing.CheckoutRepositoryPort;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class CheckoutRepository implements CheckoutRepositoryPort {
    private final SpringCheckoutRepository springCheckoutRepository;
    private final CheckoutEntityMapper checkoutEntityMapper;
    private final EntityManager entityManager;

    @Override
    public void salvar(Checkout checkout) {
        CheckoutEntity checkoutEntity;
        if (Objects.isNull(checkout.getId())) {
            checkoutEntity = checkoutEntityMapper.checkoutToCheckoutEntity(checkout);
        } else {
            checkoutEntity = this.springCheckoutRepository.findById(checkout.getId()).get();
            checkoutEntity = checkoutEntityMapper.checkoutToCheckoutEntity(checkout);
        }
        checkoutEntity = entityManager.merge(checkoutEntity);
        this.springCheckoutRepository.save(checkoutEntity);
    }

    @Override
    public List<Checkout> listar() {
        List<CheckoutEntity> checkoutEntities = this.springCheckoutRepository.findAll();
        if (!checkoutEntities.isEmpty()) {
            List<Checkout> checkouts = new ArrayList<>();
            for (CheckoutEntity checkoutEntity : checkoutEntities) {
                Checkout checkout = checkoutEntityMapper.checkoutEntityToCheckout(checkoutEntity);
                checkouts.add(checkout);
            }
            return checkouts;
        }
        return Collections.emptyList();
    }

    @Override
    public Checkout buscar(Long id) {
        Optional<CheckoutEntity> checkoutEntity = this.springCheckoutRepository.findById(id);
        if (checkoutEntity.isPresent()) {
            Checkout checkout = checkoutEntityMapper.checkoutEntityToCheckout(checkoutEntity.get());
            return checkout;
        }
        throw new RuntimeException("Checkout não encontrado");
    }
}
