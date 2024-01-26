package com.techchallenge.lanchonete.application.port.incoming.produto;

import com.techchallenge.lanchonete.application.domain.Produto;

import java.util.List;

public interface BuscarTipoProdutoUseCase {
    List<Produto> buscarTipo(String tipo);
}
