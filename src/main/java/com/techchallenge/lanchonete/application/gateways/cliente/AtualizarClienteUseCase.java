package com.techchallenge.lanchonete.application.gateways.cliente;

import com.techchallenge.lanchonete.domain.Cliente;

public interface AtualizarClienteUseCase {
    void atualizar(String cpf, Cliente cliente);
}
