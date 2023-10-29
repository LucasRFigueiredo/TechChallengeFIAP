package com.techchallenge.lanchonete.adapters.web;

import com.techchallenge.lanchonete.application.dto.PedidoDTO;
import com.techchallenge.lanchonete.application.port.incoming.pedido.CriarPedidoUseCase;
import com.techchallenge.lanchonete.application.port.incoming.pedido.ListarPedidoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Pedidos")
@RequiredArgsConstructor
public class PedidoController {
    private final CriarPedidoUseCase criarPedidoUseCase;
    private final ListarPedidoUseCase listarPedidoUseCase;

    @PostMapping
    void criarPedido(@RequestBody PedidoDTO pedidoDTO) {
        criarPedidoUseCase.criar(pedidoDTO);
    }

    @GetMapping
    List<PedidoDTO> listaProdutos() {
        return listarPedidoUseCase.listar();
    }
}
