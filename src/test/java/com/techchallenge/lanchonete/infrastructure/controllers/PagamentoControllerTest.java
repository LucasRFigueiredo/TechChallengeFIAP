package com.techchallenge.lanchonete.infrastructure.controllers;

import com.techchallenge.lanchonete.application.usecases.PagamentoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class PagamentoControllerTest {

    @Mock
    private PagamentoServiceImpl pagamentoService;
    @InjectMocks
    private PagamentoController pagamentoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testShouldVerifyIfAprovarIsBeingCalled() {
        pagamentoController.aprovar(1L);
        verify(pagamentoService).aprovar(1L);
    }

    @Test
    public void testShouldVerifyIfReprovarIsBeingCalled() {
        pagamentoController.reprovar(1L);
        verify(pagamentoService).reprovar(1L);
    }
}