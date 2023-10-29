package com.techchallenge.lanchonete.application.port.incoming.cliente;

import com.techchallenge.lanchonete.application.dto.ClienteDTO;

public interface CriarClienteUseCase {

    void criar(ClienteDTO clienteDTO);
}
