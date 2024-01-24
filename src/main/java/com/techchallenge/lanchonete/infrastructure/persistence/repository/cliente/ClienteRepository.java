package com.techchallenge.lanchonete.infrastructure.persistence.repository.cliente;

import com.techchallenge.lanchonete.infrastructure.persistence.entities.ClienteEntity;
import com.techchallenge.lanchonete.application.domain.Cliente;
import com.techchallenge.lanchonete.infrastructure.gateways.mapper.cliente.ClienteEntityMapper;
import com.techchallenge.lanchonete.application.port.outgoing.ClienteRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ClienteRepository implements ClienteRepositoryPort {

    private final SpringClienteRepository springClienteRepository;
    private final ClienteEntityMapper clienteEntityMapper;

    @Override
    public void salvar(Cliente cliente) {
        ClienteEntity clienteEntity;
        if (Objects.isNull(cliente.getCpf())) {
            clienteEntity = clienteEntityMapper.clienteToClienteEntity(cliente);
        } else {
            clienteEntity = this.springClienteRepository.findByCpf(cliente.getCpf());
            clienteEntity = clienteEntityMapper.clienteToClienteEntity(cliente);
        }
        this.springClienteRepository.save(clienteEntity);
    }

    @Override
    public Cliente buscar(String cpf) {
        ClienteEntity clienteEntity = this.springClienteRepository.findByCpf(cpf);
        if (clienteEntity != null) {
            return clienteEntityMapper.clienteEntityToCliente(clienteEntity);
        }
        throw new RuntimeException("Cliente não existe");
    }
}
