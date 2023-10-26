package com.techchallenge.lanchonete.pedido.infra.repository;

import com.techchallenge.lanchonete.pedido.infra.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringPedidoRepository extends JpaRepository<PedidoEntity, Long> {
}
