package com.techchallenge.lanchonete.produto.port.interfaces;

import com.techchallenge.lanchonete.produto.domain.Dto.ProdutoDTO;

public interface ProdutoServicePort {
    void criar(ProdutoDTO produtoDto);

    void editar(ProdutoDTO produtoDto);

    void remover(Long id);
}
