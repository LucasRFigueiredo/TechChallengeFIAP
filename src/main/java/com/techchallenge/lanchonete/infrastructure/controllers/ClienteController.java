package com.techchallenge.lanchonete.infrastructure.controllers;

import com.techchallenge.lanchonete.domain.Cliente;
import com.techchallenge.lanchonete.application.dto.ClienteDTO;
import com.techchallenge.lanchonete.infrastructure.mapper.cliente.ClienteMapper;
import com.techchallenge.lanchonete.application.usecases.ClienteServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteController {
    private final ClienteServiceImpl clienteService;
    private final ClienteMapper clienteMapper;

    public ClienteController(ClienteServiceImpl clienteService, ClienteMapper clienteMapper) {
        this.clienteService = clienteService;
        this.clienteMapper = clienteMapper;
    }

    @PostMapping
    public void criarCliente(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.clienteDTOtoCliente(clienteDTO);
        clienteService.criar(cliente);
    }

    @GetMapping(value = "/{cpf}")
    public ClienteDTO buscarCliente(@PathVariable String cpf) {
        return clienteService.buscar(cpf);
    }

    @PutMapping(value = "/{cpf}")
    public void atualizarCliente(@PathVariable String cpf, @RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.clienteDTOtoCliente(clienteDTO);
        clienteService.atualizar(cpf, cliente);
    }

    @DeleteMapping(value = "/{cpf}")
    public void deletarCliente(@PathVariable String cpf) {
        clienteService.deletar(cpf);
    }
}
