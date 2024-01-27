package com.techchallenge.lanchonete.adapters.persistence.repository.checkout;

import com.techchallenge.lanchonete.adapters.persistence.entity.CheckoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringCheckoutRepository extends JpaRepository<CheckoutEntity, Long> {
}
