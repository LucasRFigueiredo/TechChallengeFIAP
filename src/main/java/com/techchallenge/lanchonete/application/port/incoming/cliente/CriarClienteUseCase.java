package com.techchallenge.lanchonete.application.port.incoming.cliente;

import com.techchallenge.lanchonete.application.domain.Cliente;

public interface CriarClienteUseCase {

    void criar(Cliente cliente);
}
