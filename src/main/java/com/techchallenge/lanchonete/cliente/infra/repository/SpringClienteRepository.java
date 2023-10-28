package com.techchallenge.lanchonete.cliente.infra.repository;

import com.techchallenge.lanchonete.cliente.infra.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringClienteRepository extends JpaRepository<ClienteEntity, UUID> {
    ClienteEntity findByCpf(String cpf);
}
