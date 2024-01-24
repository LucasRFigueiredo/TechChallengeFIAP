package com.techchallenge.lanchonete.infrastructure.persistence.repository.pedido;

import com.techchallenge.lanchonete.infrastructure.persistence.entities.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringPedidoRepository extends JpaRepository<PedidoEntity, Long> {
}
