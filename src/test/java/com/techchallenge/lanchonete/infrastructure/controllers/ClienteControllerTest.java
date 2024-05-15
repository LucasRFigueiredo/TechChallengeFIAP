package com.techchallenge.lanchonete.infrastructure.controllers;

import com.techchallenge.lanchonete.application.dto.ClienteDTO;
import com.techchallenge.lanchonete.application.usecases.ClienteServiceImpl;
import com.techchallenge.lanchonete.infrastructure.mapper.cliente.ClienteMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class ClienteControllerTest {

    @Mock
    private ClienteServiceImpl clienteService;

    @Mock
    private ClienteMapper clienteMapper;

    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testShouldVerifyIfCriarIsBeingCalled() {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteController.criarCliente(clienteDTO);
        verify(clienteService).criar(any());
    }

    @Test
    public void testShouldVerifyIfBuscarIsBeingCalled() {
        clienteController.buscarCliente("12332113212");
        verify(clienteService).buscar(any());
    }
}
