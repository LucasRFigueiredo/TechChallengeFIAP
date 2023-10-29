package com.techchallenge.lanchonete.application.port.outgoing;

import com.techchallenge.lanchonete.application.domain.Produto;

public interface ProdutoRepositoryPort {
    void salvar(Produto produto);

    void editar(Produto produto);

    void buscar(Long id);

    void remover(Long id);
}
