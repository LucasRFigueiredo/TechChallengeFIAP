package com.techchallenge.lanchonete.application.port.incoming.produto;

import com.techchallenge.lanchonete.application.dto.ProdutoDTO;

import java.util.List;

public interface BuscarTipoProdutoUseCase {
    List<ProdutoDTO> buscarTipo(String tipo);
}
