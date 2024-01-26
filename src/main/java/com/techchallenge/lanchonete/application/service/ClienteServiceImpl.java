package com.techchallenge.lanchonete.application.service;

import com.techchallenge.lanchonete.application.domain.Cliente;
import com.techchallenge.lanchonete.application.dto.ClienteDTO;
import com.techchallenge.lanchonete.application.mapper.cliente.ClienteMapper;
import com.techchallenge.lanchonete.application.port.incoming.cliente.BuscarClienteUseCase;
import com.techchallenge.lanchonete.application.port.incoming.cliente.CriarClienteUseCase;
import com.techchallenge.lanchonete.application.port.outgoing.ClienteRepositoryPort;


public class ClienteServiceImpl {
    private final CriarClienteUseCase criarClienteUseCase;
    private final BuscarClienteUseCase buscarClienteUseCase;
    private final ClienteRepositoryPort clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteServiceImpl(CriarClienteUseCase criarClienteUseCase, BuscarClienteUseCase buscarClienteUseCase,
                              ClienteRepositoryPort clienteRepository, ClienteMapper clienteMapper) {
        this.criarClienteUseCase = criarClienteUseCase;
        this.buscarClienteUseCase = buscarClienteUseCase;
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }


    public void criar(Cliente cliente) {
        criarClienteUseCase.criar(cliente);
    }


    public ClienteDTO buscar(String cpf) {
        return clienteMapper.clienteToClienteDTO(buscarClienteUseCase.buscar(cpf));
    }
}
