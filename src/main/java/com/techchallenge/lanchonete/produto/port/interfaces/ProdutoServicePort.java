package com.techchallenge.lanchonete.produto.port.interfaces;

import com.techchallenge.lanchonete.produto.domain.Dto.ProdutoDto;

public interface ProdutoServicePort {
    void criar(ProdutoDto produtoDto);

    void editar(ProdutoDto produtoDto);

    void remover(Long id);
}
