package com.techchallenge.lanchonete.application.port.incoming.produto;

import com.techchallenge.lanchonete.application.domain.Produto;

public interface CriarProdutoUseCase {
    void criar(Produto produto);
}
