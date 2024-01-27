package com.techchallenge.lanchonete.application.gateways.cliente;

import com.techchallenge.lanchonete.domain.Cliente;

public interface BuscarClienteUseCase {
    Cliente buscar(String cpf);
}
