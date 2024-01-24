package com.techchallenge.lanchonete.infrastructure.gateways.mapper.pedido;

import com.techchallenge.lanchonete.application.domain.Pedido;
import com.techchallenge.lanchonete.application.domain.Produto;
import com.techchallenge.lanchonete.application.dto.PedidoDTO;
import com.techchallenge.lanchonete.application.dto.ProdutoDTO;
import com.techchallenge.lanchonete.infrastructure.gateways.mapper.cliente.ClienteMapper;
import com.techchallenge.lanchonete.infrastructure.gateways.mapper.produto.ProdutoMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PedidoMapper {
    public static Pedido pedidoDTOToPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        pedido.setId(pedidoDTO.getId());
        pedido.setCliente(ClienteMapper.clienteDTOtoCliente(pedidoDTO.getCliente()));
        pedido.setStatus(pedidoDTO.getStatus());

        List<Produto> produtos = new ArrayList<>();
        if (pedidoDTO.getItens() != null) {
            for (ProdutoDTO produtoDTO : pedidoDTO.getItens()) {
                produtos.add(ProdutoMapper.produtoDTOToProduto(produtoDTO));
            }
        }
        pedido.setItens(produtos);

        return pedido;
    }

    public static PedidoDTO pedidoToPedidoDTO(Pedido pedido) {
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setId(pedido.getId());
        pedidoDTO.setCliente(ClienteMapper.clienteToClienteDTO(pedido.getCliente()));
        pedidoDTO.setStatus(pedido.getStatus());

        List<ProdutoDTO> produtosDTO = new ArrayList<>();
        if (pedido.getItens() != null) {
            for (Produto produto : pedido.getItens()) {
                produtosDTO.add(ProdutoMapper.produtoToProdutoDTO(produto));
            }
        }
        pedidoDTO.setItens(produtosDTO);

        return pedidoDTO;
    }
}
