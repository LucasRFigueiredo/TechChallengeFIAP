package com.techchallenge.lanchonete.application.gateways.produto;

import com.techchallenge.lanchonete.domain.Produto;

public interface BuscarProdutoUseCase {
    Produto buscar(Long id);
}
