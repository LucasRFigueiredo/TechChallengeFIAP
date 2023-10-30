package com.techchallenge.lanchonete.adapters.persistence.repository.pedido;

import com.techchallenge.lanchonete.adapters.persistence.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringPedidoRepository extends JpaRepository<PedidoEntity, Long> {
}
