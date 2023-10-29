package com.techchallenge.lanchonete.application.port.outgoing;

import com.techchallenge.lanchonete.application.domain.Cliente;

public interface ClienteRepositoryPort {
    void salvar(Cliente cliente);

    Cliente buscar(String cpf);
}
