package com.techchallenge.lanchonete.infrastructure.controllers;

import com.techchallenge.lanchonete.application.dto.CheckoutDTO;
import com.techchallenge.lanchonete.application.usecases.CheckoutServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CheckoutControllerTest {

    @Mock
    private CheckoutServiceImpl checkoutService;

    @InjectMocks
    private CheckoutController checkoutController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testShouldPassWithNonEmptyList() {
        List<CheckoutDTO> checkoutDTOList = new ArrayList<>();
        checkoutDTOList.add(new CheckoutDTO());
        checkoutDTOList.add(new CheckoutDTO());

        when(checkoutService.buscar()).thenReturn(checkoutDTOList);

        List<CheckoutDTO> result = checkoutController.checkout();

        assertEquals(checkoutDTOList.size(), result.size());
    }

    @Test
    public void testShouldPassWithEmptyList() {
        List<CheckoutDTO> checkoutDTOList = new ArrayList<>();

        when(checkoutService.buscar()).thenReturn(checkoutDTOList);

        List<CheckoutDTO> result = checkoutController.checkout();

        assertEquals(0, result.size());
    }
}
