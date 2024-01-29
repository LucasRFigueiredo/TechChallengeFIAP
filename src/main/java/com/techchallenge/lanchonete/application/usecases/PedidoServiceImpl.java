package com.techchallenge.lanchonete.application.usecases;

import com.techchallenge.lanchonete.domain.Pedido;
import com.techchallenge.lanchonete.domain.Produto;
import com.techchallenge.lanchonete.application.dto.PedidoDTO;
import com.techchallenge.lanchonete.infrastructure.mapper.pedido.PedidoMapper;
import com.techchallenge.lanchonete.application.gateways.cliente.BuscarClienteUseCase;
import com.techchallenge.lanchonete.application.gateways.pedido.CriarPedidoUseCase;
import com.techchallenge.lanchonete.application.gateways.pedido.ListarPedidoUseCase;
import com.techchallenge.lanchonete.application.gateways.produto.BuscarProdutoUseCase;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class PedidoServiceImpl {
    private final CriarPedidoUseCase criarPedidoUseCase;
    private final ListarPedidoUseCase listarPedidoUseCase;
    private final BuscarProdutoUseCase buscarProdutoUseCase;
    private final BuscarClienteUseCase buscarClienteUseCase;
    private final PedidoMapper pedidoMapper;
    private final CheckoutServiceImpl checkoutService;

    public PedidoServiceImpl(CriarPedidoUseCase criarPedidoUseCase, ListarPedidoUseCase listarPedidoUseCase,
                             BuscarProdutoUseCase buscarProdutoUseCase, BuscarClienteUseCase buscarClienteUseCase,
                             PedidoMapper pedidoMapper, CheckoutServiceImpl checkoutService) {
        this.criarPedidoUseCase = criarPedidoUseCase;
        this.listarPedidoUseCase = listarPedidoUseCase;
        this.buscarProdutoUseCase = buscarProdutoUseCase;
        this.buscarClienteUseCase = buscarClienteUseCase;
        this.pedidoMapper = pedidoMapper;
        this.checkoutService = checkoutService;
    }

    @Transactional
    public void criar(PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoMapper.pedidoDTOToPedido(pedidoDTO);
        pedido.setCliente(buscarClienteUseCase.buscar(pedido.getCliente().getCpf()));

        List<Produto> produtos = Optional.ofNullable(pedido.getItens()).orElse(Collections.emptyList());
        if (!produtos.isEmpty()) {
            for (Produto produto : produtos) {
                buscarProdutoUseCase.buscar(produto.getId());
                //TODO logica de estoque no futuro?
            }
        }
        Long pedidoId = criarPedidoUseCase.criar(pedido);
        pedido.setId(pedidoId);
        checkoutService.criar(pedido);
    }

    public List<PedidoDTO> listar() {
        List<Pedido> pedidos = this.listarPedidoUseCase.listar();
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
