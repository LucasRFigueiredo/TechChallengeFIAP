package com.techchallenge.lanchonete.pedido.adapter;

import com.techchallenge.lanchonete.pedido.domain.dto.PedidoDTO;
import com.techchallenge.lanchonete.pedido.port.interfaces.PedidoServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Pedidos")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoServicePort pedidoServicePort;

    @PostMapping
    void criarPedido(@RequestBody PedidoDTO pedidoDTO) {
        pedidoServicePort.criar(pedidoDTO);
    }

    @GetMapping
    List<PedidoDTO> listaProdutos() {
        return pedidoServicePort.listar();
    }
}
