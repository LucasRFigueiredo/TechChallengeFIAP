package com.techchallenge.lanchonete.application.service;

import com.techchallenge.lanchonete.application.domain.Produto;
import com.techchallenge.lanchonete.application.dto.ProdutoDTO;
import com.techchallenge.lanchonete.infrastructure.gateways.mapper.produto.ProdutoMapper;
import com.techchallenge.lanchonete.application.port.incoming.produto.BuscarTipoProdutoUseCase;
import com.techchallenge.lanchonete.application.port.incoming.produto.CriarProdutoUseCase;
import com.techchallenge.lanchonete.application.port.incoming.produto.EditarProdutoUseCase;
import com.techchallenge.lanchonete.application.port.incoming.produto.RemoverProdutoUseCase;
import com.techchallenge.lanchonete.application.port.outgoing.ProdutoRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ProdutoServiceImpl {
    private final CriarProdutoUseCase criarProdutoUseCase;
    private final BuscarTipoProdutoUseCase buscarTipoProdutoUseCase;
    private final EditarProdutoUseCase editarProdutoUseCase;
    private final RemoverProdutoUseCase removerProdutoUseCase;
    private final ProdutoRepositoryPort produtoRepository;
    private final ProdutoMapper produtoMapper;

    public ProdutoServiceImpl(CriarProdutoUseCase criarProdutoUseCase, BuscarTipoProdutoUseCase buscarTipoProdutoUseCase,
                              EditarProdutoUseCase editarProdutoUseCase, RemoverProdutoUseCase removerProdutoUseCase,
                              ProdutoRepositoryPort produtoRepository, ProdutoMapper produtoMapper) {
        this.criarProdutoUseCase = criarProdutoUseCase;
        this.buscarTipoProdutoUseCase = buscarTipoProdutoUseCase;
        this.editarProdutoUseCase = editarProdutoUseCase;
        this.removerProdutoUseCase = removerProdutoUseCase;
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    public void criar(ProdutoDTO produtoDto) {
        Produto produto = produtoMapper.produtoDTOToProduto(produtoDto);
        this.produtoRepository.salvar(produto);
    }


    public List<ProdutoDTO> buscarTipo(String tipo) {
        List<Produto> produtos = this.produtoRepository.buscarTipo(tipo);
        if (!produtos.isEmpty()) {
            List<ProdutoDTO> produtoDTOS = new ArrayList<>();
            for (Produto produto : produtos) {
                ProdutoDTO produtoDTO = new ProdutoDTO();
                produtoDTO = produtoMapper.produtoToProdutoDTO(produto);
                produtoDTOS.add(produtoDTO);
            }
            return produtoDTOS;
        }
        return Collections.emptyList();
    }


    public void editar(ProdutoDTO produtoDto, Long id) {
        Produto produto = produtoMapper.produtoDTOToProduto(produtoDto);
        this.produtoRepository.editar(produto, id);
    }


    public void remover(Long id) {
        this.produtoRepository.remover(id);
    }


}
