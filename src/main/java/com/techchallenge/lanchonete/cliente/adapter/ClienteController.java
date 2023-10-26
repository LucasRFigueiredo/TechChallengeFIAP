package com.techchallenge.lanchonete.cliente.adapter;

import com.techchallenge.lanchonete.cliente.domain.dto.ClienteDTO;
import com.techchallenge.lanchonete.cliente.port.interfaces.ClienteServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteServicePort clienteServicePort;

    @PostMapping
    void criarCliente(@RequestBody ClienteDTO clienteDTO) {
        clienteServicePort.salvar(clienteDTO);
    }

    @GetMapping
    ClienteDTO buscarCliente(@PathVariable String cpf) {
        return clienteServicePort.buscar(cpf);
    }

}
