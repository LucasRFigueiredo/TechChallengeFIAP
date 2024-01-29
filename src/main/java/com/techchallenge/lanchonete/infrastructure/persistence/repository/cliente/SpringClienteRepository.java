package com.techchallenge.lanchonete.infrastructure.persistence.repository.cliente;

import com.techchallenge.lanchonete.infrastructure.persistence.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringClienteRepository extends JpaRepository<ClienteEntity, Long> {
    ClienteEntity findByCpf(String cpf);
}
