package com.techchallenge.lanchonete.application.gateways.produto;

import com.techchallenge.lanchonete.domain.Produto;

import java.util.List;

public interface BuscarTipoProdutoUseCase {
    List<Produto> buscarTipo(String tipo);
}
