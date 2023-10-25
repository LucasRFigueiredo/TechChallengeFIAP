package com.techchallenge.lanchonete.produto.infra.repository;

import com.techchallenge.lanchonete.produto.domain.entity.Produto;
import com.techchallenge.lanchonete.produto.port.repository.ProdutoRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class ProdutoRepository implements ProdutoRepositoryPort {
    @Override
    public void salvar(Produto produto) {

    }
}
