package com.techchallenge.lanchonete.application.port.incoming.pedido;

import com.techchallenge.lanchonete.application.domain.Pedido;

import java.util.List;

public interface ListarPedidoUseCase {

    List<Pedido> listar();
}
