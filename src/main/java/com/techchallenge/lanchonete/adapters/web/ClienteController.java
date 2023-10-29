package com.techchallenge.lanchonete.adapters.web;

import com.techchallenge.lanchonete.application.dto.ClienteDTO;
import com.techchallenge.lanchonete.application.port.incoming.cliente.BuscarClienteUseCase;
import com.techchallenge.lanchonete.application.port.incoming.cliente.CriarClienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final CriarClienteUseCase criarClienteUseCase;
    private final BuscarClienteUseCase buscarClienteUseCase;

    @PostMapping
    void criarCliente(@RequestBody ClienteDTO clienteDTO) {
        criarClienteUseCase.criar(clienteDTO);
    }

    @GetMapping(value = "/{cpf}")
    ClienteDTO buscarCliente(@PathVariable String cpf) {
        return buscarClienteUseCase.buscar(cpf);
    }

}
