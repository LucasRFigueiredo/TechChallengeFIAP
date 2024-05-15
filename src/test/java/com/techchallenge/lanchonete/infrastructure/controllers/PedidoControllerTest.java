package com.techchallenge.lanchonete.infrastructure.controllers;

import com.techchallenge.lanchonete.application.dto.PedidoDTO;
import com.techchallenge.lanchonete.application.usecases.PedidoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class PedidoControllerTest {

    @Mock
    private PedidoServiceImpl pedidoService;
    @InjectMocks
    private PedidoController pedidoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testShouldVerifyIfCriarIsBeingCalled() {
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoController.criarPedido(pedidoDTO);
        verify(pedidoService).criar(pedidoDTO);
    }

    @Test
    public void testShouldVerifyIfListarIsBeingCalled() {
        pedidoController.listaPedidos();
        verify(pedidoService).listar();
    }

}