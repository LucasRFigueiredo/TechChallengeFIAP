package com.techchallenge.lanchonete.produto.domain.mapper;

import com.techchallenge.lanchonete.produto.domain.Dto.ProdutoDTO;
import com.techchallenge.lanchonete.produto.domain.entity.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {
    public static Produto produtoDTOToProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setId(produtoDTO.getId());
        produto.setTipo(produtoDTO.getTipo());
        produto.setNome(produtoDTO.getNome());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setPreco(produtoDTO.getPreco());
        return produto;
    }

    public static ProdutoDTO produtoToProdutoDTO(Produto produto) {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(produto.getId());
        produtoDTO.setTipo(produto.getTipo());
        produtoDTO.setNome(produto.getNome());
        produtoDTO.setDescricao(produto.getDescricao());
        produtoDTO.setPreco(produto.getPreco());
        return produtoDTO;
    }
}

