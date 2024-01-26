package com.techchallenge.lanchonete.adapters.web;

import com.techchallenge.lanchonete.application.dto.PedidoDTO;
import com.techchallenge.lanchonete.application.service.PedidoServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedidos")
public class PedidoController {
    private final PedidoServiceImpl pedidoService;

    public PedidoController(PedidoServiceImpl pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    void criarPedido(@RequestBody PedidoDTO pedidoDTO) {
        pedidoService.criar(pedidoDTO);
    }

    @GetMapping
    List<PedidoDTO> listaPedidos() {
        return pedidoService.listar();
    }
}
