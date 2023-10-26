package com.techchallenge.lanchonete.produto.port.repository;

import com.techchallenge.lanchonete.produto.domain.entity.Produto;

public interface ProdutoRepositoryPort {
    void salvar(Produto produto);

    void editar(Produto produto);

    void buscar(Long id);

    void remover(Long id);
}
