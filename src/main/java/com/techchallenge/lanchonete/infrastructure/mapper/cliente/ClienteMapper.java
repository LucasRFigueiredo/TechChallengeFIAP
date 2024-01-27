package com.techchallenge.lanchonete.infrastructure.mapper.cliente;


import com.techchallenge.lanchonete.domain.Cliente;
import com.techchallenge.lanchonete.application.dto.ClienteDTO;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {
    public static Cliente clienteDTOtoCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setEmail(clienteDTO.getEmail());
        return cliente;
    }

    public static ClienteDTO clienteToClienteDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNome(cliente.getNome());
        clienteDTO.setCpf(cliente.getCpf());
        clienteDTO.setEmail(cliente.getEmail());
        return clienteDTO;
    }
}
