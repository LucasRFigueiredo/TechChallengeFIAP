package com.techchallenge.lanchonete.application.port.incoming.produto;

import com.techchallenge.lanchonete.application.dto.ProdutoDTO;

public interface EditarProdutoUseCase {

    void editar(ProdutoDTO produtoDto, Long id);
}
