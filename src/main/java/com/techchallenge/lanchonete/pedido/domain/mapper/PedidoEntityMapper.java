package com.techchallenge.lanchonete.pedido.domain.mapper;

import com.techchallenge.lanchonete.cliente.domain.mapper.ClienteEntityMapper;
import com.techchallenge.lanchonete.pedido.domain.entity.Pedido;
import com.techchallenge.lanchonete.pedido.infra.entity.PedidoEntity;
import com.techchallenge.lanchonete.produto.domain.entity.Produto;
import com.techchallenge.lanchonete.produto.domain.mapper.ProdutoEntityMapper;
import com.techchallenge.lanchonete.produto.infra.entity.ProdutoEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PedidoEntityMapper {
    public static Pedido pedidoEntityToPedido(PedidoEntity pedidoEntity) {
        Pedido pedido = new Pedido();
        pedido.setId(pedidoEntity.getId());
        pedido.setCliente(ClienteEntityMapper.clienteEntityToCliente(pedidoEntity.getCliente()));
        pedido.setStatus(pedidoEntity.getStatus());

        List<Produto> produtos = new ArrayList<>();
        for (ProdutoEntity produtoEntity : pedidoEntity.getProdutos()) {
            produtos.add(ProdutoEntityMapper.produtoEntityToProduto(produtoEntity));
        }
        pedido.setItens(produtos);

        return pedido;
    }

    public static PedidoEntity pedidoToPedidoEntity(Pedido pedido) {
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setId(pedido.getId());
        pedidoEntity.setCliente(ClienteEntityMapper.clienteToClienteEntity(pedido.getCliente()));
        pedidoEntity.setStatus(pedido.getStatus());

        List<ProdutoEntity> produtos = new ArrayList<>();
        for (Produto produto : pedido.getItens()) {
            produtos.add(ProdutoEntityMapper.produtoToProdutoEntity(produto));
        }
        pedidoEntity.setProdutos(produtos);

        return pedidoEntity;
    }
}
