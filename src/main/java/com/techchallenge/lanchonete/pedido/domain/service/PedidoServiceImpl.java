package com.techchallenge.lanchonete.pedido.domain.service;

import com.techchallenge.lanchonete.cliente.port.repository.ClienteRepositoryPort;
import com.techchallenge.lanchonete.pedido.domain.dto.PedidoDTO;
import com.techchallenge.lanchonete.pedido.domain.entity.Pedido;
import com.techchallenge.lanchonete.pedido.domain.mapper.PedidoMapper;
import com.techchallenge.lanchonete.pedido.port.interfaces.PedidoServicePort;
import com.techchallenge.lanchonete.pedido.port.repository.PedidoRepositoryPort;
import com.techchallenge.lanchonete.produto.domain.entity.Produto;
import com.techchallenge.lanchonete.produto.port.repository.ProdutoRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class PedidoServiceImpl implements PedidoServicePort {
    private final PedidoRepositoryPort pedidoRepository;
    private final ClienteRepositoryPort clienteRepositoryPort;
    private final ProdutoRepositoryPort produtoRepositoryPort;
    private final PedidoMapper pedidoMapper;

    @Override
    public void criar(PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoMapper.pedidoDTOToPedido(pedidoDTO);
        clienteRepositoryPort.buscar(pedido.getCliente().getCpf());
        List<Produto> produtos = Optional.ofNullable(pedido.getItens()).orElse(Collections.emptyList());
        if (!produtos.isEmpty()) {
            for (Produto produto : produtos) {
                produtoRepositoryPort.buscar(produto.getId());
                //TODO logica de estoque no futuro?
            }
        }
        this.pedidoRepository.salvar(pedido);
    }

    @Override
    public List<PedidoDTO> listar() {
        List<Pedido> pedidos = this.pedidoRepository.listarPedido();
        return pedidoMapper.pedidosToPedidoDTOs(pedidos);
    }
}
