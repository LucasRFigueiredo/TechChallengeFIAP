package com.techchallenge.lanchonete.application.port.incoming.pedido;

import com.techchallenge.lanchonete.application.domain.Pedido;

public interface CriarPedidoUseCase {
    Long criar(Pedido pedido);
}
