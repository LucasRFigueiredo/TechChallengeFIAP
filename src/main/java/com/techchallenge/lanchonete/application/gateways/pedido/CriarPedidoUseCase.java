package com.techchallenge.lanchonete.application.gateways.pedido;

import com.techchallenge.lanchonete.domain.Pedido;

public interface CriarPedidoUseCase {
    Long criar(Pedido pedido);
}
