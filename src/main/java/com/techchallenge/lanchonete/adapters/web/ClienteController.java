package com.techchallenge.lanchonete.adapters.web;

import com.techchallenge.lanchonete.application.domain.Cliente;
import com.techchallenge.lanchonete.application.dto.ClienteDTO;
import com.techchallenge.lanchonete.application.mapper.cliente.ClienteMapper;
import com.techchallenge.lanchonete.application.service.ClienteServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteController {
    private final ClienteServiceImpl criarClienteUseCase;
    private final ClienteMapper clienteMapper;

    public ClienteController(ClienteServiceImpl criarClienteUseCase, ClienteMapper clienteMapper) {
        this.criarClienteUseCase = criarClienteUseCase;
        this.clienteMapper = clienteMapper;
    }

    @PostMapping
    void criarCliente(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.clienteDTOtoCliente(clienteDTO);
        criarClienteUseCase.criar(cliente);
    }

    @GetMapping(value = "/{cpf}")
    ClienteDTO buscarCliente(@PathVariable String cpf) {
        return criarClienteUseCase.buscar(cpf);
    }

}
