package com.techchallenge.lanchonete.cliente.infra.repository;

import com.techchallenge.lanchonete.cliente.domain.entity.Cliente;
import com.techchallenge.lanchonete.cliente.domain.mapper.ClienteEntityMapper;
import com.techchallenge.lanchonete.cliente.infra.entity.ClienteEntity;
import com.techchallenge.lanchonete.cliente.port.repository.ClienteRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

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
            clienteEntity = this.springClienteRepository.findByCpf(cliente.getCpf()).get();
            clienteEntity = clienteEntityMapper.clienteToClienteEntity(cliente);
        }
        this.springClienteRepository.save(clienteEntity);
    }

    @Override
    public Cliente buscar(String cpf) {
        Optional<ClienteEntity> clienteEntity = this.springClienteRepository.findByCpf(cpf);
        if (clienteEntity.isPresent()) {
            return clienteEntityMapper.clienteEntityToCliente(clienteEntity.get());
        }
        throw new RuntimeException("Cliente não existe");
    }
}
