package com.techchallenge.lanchonete.application.usecases;

import com.techchallenge.lanchonete.domain.Cliente;
import com.techchallenge.lanchonete.application.dto.ClienteDTO;
import com.techchallenge.lanchonete.infrastructure.mapper.cliente.ClienteMapper;
import com.techchallenge.lanchonete.application.gateways.cliente.BuscarClienteUseCase;
import com.techchallenge.lanchonete.application.gateways.cliente.CriarClienteUseCase;
import com.techchallenge.lanchonete.application.events.EventPublisher;

public class ClienteServiceImpl {
    private final CriarClienteUseCase criarClienteUseCase;
    private final BuscarClienteUseCase buscarClienteUseCase;
    private final ClienteMapper clienteMapper;
    private final EventPublisher eventPublisher;

    public ClienteServiceImpl(CriarClienteUseCase criarClienteUseCase, BuscarClienteUseCase buscarClienteUseCase,
                              ClienteMapper clienteMapper, EventPublisher eventPublisher) {
        this.criarClienteUseCase = criarClienteUseCase;
        this.buscarClienteUseCase = buscarClienteUseCase;
        this.clienteMapper = clienteMapper;
        this.eventPublisher = eventPublisher;
    }

    public void criar(Cliente cliente) {
        criarClienteUseCase.criar(cliente);
        ClienteDTO clienteDTO = clienteMapper.clienteToClienteDTO(cliente);
        eventPublisher.publishClientCreatedEvent(clienteDTO);
    }

    public ClienteDTO buscar(String cpf) {
        Cliente cliente = buscarClienteUseCase.buscar(cpf);
        return clienteMapper.clienteToClienteDTO(cliente);
    }
}
