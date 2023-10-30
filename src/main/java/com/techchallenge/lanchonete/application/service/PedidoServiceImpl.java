package com.techchallenge.lanchonete.application.service;

import com.techchallenge.lanchonete.application.domain.Pedido;
import com.techchallenge.lanchonete.application.domain.Produto;
import com.techchallenge.lanchonete.application.dto.PedidoDTO;
import com.techchallenge.lanchonete.application.mapper.pedido.PedidoMapper;
import com.techchallenge.lanchonete.application.port.incoming.pedido.CriarPedidoUseCase;
import com.techchallenge.lanchonete.application.port.incoming.pedido.ListarPedidoUseCase;
import com.techchallenge.lanchonete.application.port.outgoing.ClienteRepositoryPort;
import com.techchallenge.lanchonete.application.port.outgoing.PedidoRepositoryPort;
import com.techchallenge.lanchonete.application.port.outgoing.ProdutoRepositoryPort;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class PedidoServiceImpl implements CriarPedidoUseCase, ListarPedidoUseCase {
    private final PedidoMapper pedidoMapper;
    private final PedidoRepositoryPort pedidoRepository;
    private final ClienteRepositoryPort clienteRepositoryPort;
    private final ProdutoRepositoryPort produtoRepositoryPort;
    private final CheckoutServiceImpl checkoutService;


    @Override
    @Transactional
    public void criar(PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoMapper.pedidoDTOToPedido(pedidoDTO);
        pedido.setCliente(clienteRepositoryPort.buscar(pedido.getCliente().getCpf()));

        List<Produto> produtos = Optional.ofNullable(pedido.getItens()).orElse(Collections.emptyList());
        if (!produtos.isEmpty()) {
            for (Produto produto : produtos) {
                produtoRepositoryPort.buscar(produto.getId());
                //TODO logica de estoque no futuro?
            }
        }
        pedidoRepository.salvar(pedido);
        checkoutService.criar(pedido);
    }

    @Override
    public List<PedidoDTO> listar() {
        List<Pedido> pedidos = this.pedidoRepository.listarPedido();
        if (!pedidos.isEmpty()) {
            List<PedidoDTO> pedidoDTOS = new ArrayList<>();
            for (Pedido pedido : pedidos) {
                PedidoDTO pedidoDTO = pedidoMapper.pedidoToPedidoDTO(pedido);
                pedidoDTOS.add(pedidoDTO);
            }
            return pedidoDTOS;
        } else {
            return Collections.emptyList();
        }
    }
}
