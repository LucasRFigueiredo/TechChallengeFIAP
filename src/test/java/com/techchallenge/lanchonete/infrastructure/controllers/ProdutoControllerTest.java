package com.techchallenge.lanchonete.infrastructure.controllers;

import com.techchallenge.lanchonete.application.dto.ProdutoDTO;
import com.techchallenge.lanchonete.application.usecases.ProdutoServiceImpl;
import com.techchallenge.lanchonete.infrastructure.mapper.produto.ProdutoMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class ProdutoControllerTest {
    @Mock
    private ProdutoServiceImpl produtoService;
    @Mock
    private ProdutoMapper produtoMapper;
    @InjectMocks
    private ProdutoController produtoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testShouldVerifyIfCriarIsBeingCalled() {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoController.criarProduto(produtoDTO);
        verify(produtoService).criar(any());
    }

    @Test
    public void testShouldVerifyIfBuscarPorTipoIsBeingCalled() {
        produtoController.buscarProdutoPorTipo("lanche");
        verify(produtoService).buscarTipo("lanche");
    }

    @Test
    public void testShouldVerifyIfEditarIsBeingCalled() {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoController.editarProduto(produtoDTO, 1L);
        verify(produtoService).editar(any(), any());
    }

    @Test
    public void testShouldVerifyIfDeleteIsBeingCalled() {
        produtoController.removerProduto(1L);
        verify(produtoService).remover(any());
    }
}