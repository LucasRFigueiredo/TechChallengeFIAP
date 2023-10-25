package com.techchallenge.lanchonete.cliente.port.interfaces;

import com.techchallenge.lanchonete.cliente.domain.dto.ClienteDTO;

public interface ClienteServicePort {

    void criarCliente(ClienteDTO clienteDTO);
    ClienteDTO buscarCliente(String cpf);
}
