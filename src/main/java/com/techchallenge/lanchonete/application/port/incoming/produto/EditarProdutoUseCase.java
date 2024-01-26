package com.techchallenge.lanchonete.application.port.incoming.produto;

import com.techchallenge.lanchonete.application.domain.Produto;

public interface EditarProdutoUseCase {

    void editar(Produto produto, Long id);
}
