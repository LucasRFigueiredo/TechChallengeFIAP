package com.techchallenge.lanchonete.application.port.incoming.pedido;

import com.techchallenge.lanchonete.application.dto.PedidoDTO;

public interface CriarPedidoUseCase {
    void criar(PedidoDTO pedidoDTO);
}
