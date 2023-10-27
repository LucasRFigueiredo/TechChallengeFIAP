package com.techchallenge.lanchonete.produto.domain.mapper;

import com.techchallenge.lanchonete.produto.domain.entity.Produto;
import com.techchallenge.lanchonete.produto.infra.entity.ProdutoEntity;
import org.springframework.stereotype.Component;

@Component
public class ProdutoEntityMapper {
    public static Produto produtoEntityToProduto(ProdutoEntity produtoEntity) {
        Produto produto = new Produto();
        produto.setId(produtoEntity.getId());
        produto.setTipo(produtoEntity.getTipo());
        produto.setNome(produtoEntity.getNome());
        produto.setDescricao(produtoEntity.getDescricao());
        produto.setPreco(produtoEntity.getPreco());
        return produto;
    }

    public static ProdutoEntity produtoToProdutoEntity(Produto produto) {
        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setId(produto.getId());
        produtoEntity.setTipo(produto.getTipo());
        produtoEntity.setNome(produto.getNome());
        produtoEntity.setDescricao(produto.getDescricao());
        produtoEntity.setPreco(produto.getPreco());
        return produtoEntity;
    }
}

