package com.techchallenge.lanchonete.pedido.port.interfaces;

import com.techchallenge.lanchonete.pedido.domain.dto.PedidoDTO;

import java.util.List;

public interface PedidoServicePort {
    void criarPedido(PedidoDTO pedidoDTO);

    List<PedidoDTO> listarPedido();
}
