package com.techchallenge.lanchonete.infrastructure.gateways;

import com.techchallenge.lanchonete.infrastructure.persistence.entity.ClienteEntity;
import com.techchallenge.lanchonete.infrastructure.persistence.repository.cliente.SpringClienteRepository;
import com.techchallenge.lanchonete.domain.Cliente;
import com.techchallenge.lanchonete.infrastructure.mapper.cliente.ClienteEntityMapper;
import com.techchallenge.lanchonete.application.gateways.cliente.BuscarClienteUseCase;
import com.techchallenge.lanchonete.application.gateways.cliente.CriarClienteUseCase;
import com.techchallenge.lanchonete.application.gateways.cliente.AtualizarClienteUseCase;
import com.techchallenge.lanchonete.application.gateways.cliente.DeletarClienteUseCase;

public class ClienteRepositoryGateway implements CriarClienteUseCase, BuscarClienteUseCase, AtualizarClienteUseCase, DeletarClienteUseCase {

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

    @Override
    public void atualizar(String cpf, Cliente cliente) {
        ClienteEntity existingClienteEntity = springClienteRepository.findByCpf(cpf);
        if (existingClienteEntity != null) {
            ClienteEntity updatedClienteEntity = clienteEntityMapper.clienteToClienteEntity(cliente);
            updatedClienteEntity.setId(existingClienteEntity.getId()); // Mantém o mesmo ID do cliente existente
            springClienteRepository.save(updatedClienteEntity);
        } else {
            throw new RuntimeException("Cliente não encontrado com o CPF: " + cpf);
        }
    }

    @Override
    public void deletar(String cpf) {
        ClienteEntity clienteEntity = springClienteRepository.findByCpf(cpf);
        if (clienteEntity != null) {
            springClienteRepository.delete(clienteEntity);
        } else {
            throw new RuntimeException("Cliente não encontrado com o CPF: " + cpf);
        }
    }
}
