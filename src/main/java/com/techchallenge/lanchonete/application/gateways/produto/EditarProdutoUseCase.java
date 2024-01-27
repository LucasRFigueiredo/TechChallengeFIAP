package com.techchallenge.lanchonete.application.gateways.produto;

import com.techchallenge.lanchonete.domain.Produto;

public interface EditarProdutoUseCase {

    void editar(Produto produto, Long id);
}
