package com.techchallenge.lanchonete.application.mapper.produto;

import com.techchallenge.lanchonete.adapters.persistence.entity.ProdutoEntity;
import com.techchallenge.lanchonete.application.domain.Produto;
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

