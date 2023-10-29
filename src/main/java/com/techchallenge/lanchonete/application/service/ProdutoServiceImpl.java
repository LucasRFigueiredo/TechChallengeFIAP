package com.techchallenge.lanchonete.application.service;

import com.techchallenge.lanchonete.application.domain.Produto;
import com.techchallenge.lanchonete.application.dto.ProdutoDTO;
import com.techchallenge.lanchonete.application.mapper.produto.ProdutoMapper;
import com.techchallenge.lanchonete.application.port.incoming.produto.CriarProdutoUseCase;
import com.techchallenge.lanchonete.application.port.incoming.produto.EditarProdutoUseCase;
import com.techchallenge.lanchonete.application.port.incoming.produto.RemoverProdutoUseCase;
import com.techchallenge.lanchonete.application.port.outgoing.ProdutoRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProdutoServiceImpl implements CriarProdutoUseCase, EditarProdutoUseCase, RemoverProdutoUseCase {
    private final ProdutoRepositoryPort produtoRepository;
    private final ProdutoMapper produtoMapper;

    @Override
    public void criar(ProdutoDTO produtoDto) {
        Produto produto = produtoMapper.produtoDTOToProduto(produtoDto);
        this.produtoRepository.salvar(produto);
    }

    @Override
    public void editar(ProdutoDTO produtoDto) {
        Produto produto = produtoMapper.produtoDTOToProduto(produtoDto);
        this.produtoRepository.editar(produto);
    }

    @Override
    public void remover(Long id) {
        this.produtoRepository.remover(id);
    }
}
