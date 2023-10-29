package com.techchallenge.lanchonete.application.port.incoming.produto;

import com.techchallenge.lanchonete.application.dto.ProdutoDTO;

public interface CriarProdutoUseCase {
    void criar(ProdutoDTO produtoDto);
}
