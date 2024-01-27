package com.techchallenge.lanchonete.infrastructure.gateways;

import com.techchallenge.lanchonete.infrastructure.persistence.entity.ClienteEntity;
import com.techchallenge.lanchonete.infrastructure.persistence.repository.cliente.SpringClienteRepository;
import com.techchallenge.lanchonete.domain.Cliente;
import com.techchallenge.lanchonete.infrastructure.mapper.cliente.ClienteEntityMapper;
import com.techchallenge.lanchonete.application.gateways.cliente.BuscarClienteUseCase;
import com.techchallenge.lanchonete.application.gateways.cliente.CriarClienteUseCase;

public class ClienteRepositoryGateway implements CriarClienteUseCase, BuscarClienteUseCase {

    private final SpringClienteRepository springClienteRepository;
    private final ClienteEntityMapper clienteEntityMapper;

    public ClienteRepositoryGateway(SpringClienteRepository springClienteRepository, ClienteEntityMapper clienteEntityMapper) {
        this.springClienteRepository = springClienteRepository;
        this.clienteEntityMapper = clienteEntityMapper;
    }

    @Override
    public void criar(Cliente cliente) {
        ClienteEntity clienteEntity = clienteEntityMapper.clienteToClienteEntity(cliente);
        springClienteRepository.save(clienteEntity);
    }

    @Override
    public Cliente buscar(String cpf) {
        ClienteEntity clienteEntity = springClienteRepository.findByCpf(cpf);
        return clienteEntityMapper.clienteEntityToCliente(clienteEntity);
    }
}
