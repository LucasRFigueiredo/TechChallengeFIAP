package com.techchallenge.lanchonete.infrastructure.mapper.cliente;

import com.techchallenge.lanchonete.infrastructure.persistence.entity.ClienteEntity;
import com.techchallenge.lanchonete.domain.Cliente;
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
