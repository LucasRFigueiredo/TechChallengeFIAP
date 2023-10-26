package com.techchallenge.lanchonete.pedido.domain.mapper;

import com.techchallenge.lanchonete.pedido.domain.dto.PedidoDTO;
import com.techchallenge.lanchonete.pedido.domain.entity.Pedido;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PedidoMapper {
    Pedido pedidoDTOToPedido(PedidoDTO pedidoDTO);

    List<PedidoDTO> pedidosToPedidoDTOs(List<Pedido> pedido);
}
