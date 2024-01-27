package com.techchallenge.lanchonete.application.gateways.pedido;

import com.techchallenge.lanchonete.domain.Pedido;

import java.util.List;

public interface ListarPedidoUseCase {

    List<Pedido> listar();
}
