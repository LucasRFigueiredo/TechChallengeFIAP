package com.techchallenge.lanchonete.adapters.web;

import com.techchallenge.lanchonete.application.dto.CheckoutDTO;
import com.techchallenge.lanchonete.application.dto.PedidoDTO;
import com.techchallenge.lanchonete.application.port.incoming.checkout.CheckoutUseCase;
import com.techchallenge.lanchonete.application.port.incoming.pedido.CriarPedidoUseCase;
import com.techchallenge.lanchonete.application.port.incoming.pedido.ListarPedidoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedidos")
@RequiredArgsConstructor
public class PedidoController {
    private final CriarPedidoUseCase criarPedidoUseCase;
    private final ListarPedidoUseCase listarPedidoUseCase;
    private final CheckoutUseCase checkoutUseCase;

    @PostMapping
    void criarPedido(@RequestBody PedidoDTO pedidoDTO) {
        criarPedidoUseCase.criar(pedidoDTO);
    }

    @GetMapping
    List<PedidoDTO> listaPedidos() {
        return listarPedidoUseCase.listar();
    }

    @GetMapping(value = "/{id}")
    CheckoutDTO checkout(@PathVariable Long id) {
        return checkoutUseCase.buscar(id);
    }
}
