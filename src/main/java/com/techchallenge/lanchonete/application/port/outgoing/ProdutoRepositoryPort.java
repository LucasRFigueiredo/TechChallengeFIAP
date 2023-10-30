package com.techchallenge.lanchonete.application.port.outgoing;

import com.techchallenge.lanchonete.application.domain.Produto;

import java.util.List;

public interface ProdutoRepositoryPort {
    void salvar(Produto produto);

    void buscar(Long id);

    List<Produto> buscarTipo(String tipo);

    void editar(Produto produto, Long id);

    void remover(Long id);
}
