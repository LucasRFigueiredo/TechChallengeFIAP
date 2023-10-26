package com.techchallenge.lanchonete.pedido.port.repository;

import com.techchallenge.lanchonete.pedido.domain.entity.Pedido;

import java.util.List;

public interface PedidoRepositoryPort {
    void salvar(Pedido pedido);

    List<Pedido> listarPedido();
}
