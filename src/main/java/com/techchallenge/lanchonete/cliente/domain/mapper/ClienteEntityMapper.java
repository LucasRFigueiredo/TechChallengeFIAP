package com.techchallenge.lanchonete.cliente.domain.mapper;

import com.techchallenge.lanchonete.cliente.domain.entity.Cliente;
import com.techchallenge.lanchonete.cliente.infra.entity.ClienteEntity;
import org.springframework.stereotype.Component;

@Component
public class ClienteEntityMapper {
    public static Cliente clienteEntityToCliente(ClienteEntity clienteEntity) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteEntity.getId());
        cliente.setNome(clienteEntity.getNome());
        cliente.setCpf(clienteEntity.getCpf());
        cliente.setEmail(clienteEntity.getEmail());
        return cliente;
    }

    public static ClienteEntity clienteToClienteEntity(Cliente cliente) {
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setId(cliente.getId());
        clienteEntity.setNome(cliente.getNome());
        clienteEntity.setCpf(cliente.getCpf());
        clienteEntity.setEmail(cliente.getEmail());
        return clienteEntity;
    }
}
