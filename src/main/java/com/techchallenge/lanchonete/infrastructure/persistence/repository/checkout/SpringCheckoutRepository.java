package com.techchallenge.lanchonete.infrastructure.persistence.repository.checkout;

import com.techchallenge.lanchonete.infrastructure.persistence.entities.CheckoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringCheckoutRepository extends JpaRepository<CheckoutEntity, Long> {
}
