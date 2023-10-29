package com.techchallenge.lanchonete.application.port.outgoing;

import com.techchallenge.lanchonete.application.domain.Pedido;

import java.util.List;

public interface PedidoRepositoryPort {
    void salvar(Pedido pedido);

    List<Pedido> listarPedido();
}
