package com.techchallenge.lanchonete.application.port.incoming.pedido;

import com.techchallenge.lanchonete.application.dto.PedidoDTO;

import java.util.List;

public interface ListarPedidoUseCase {

    List<PedidoDTO> listar();
}
