package com.techchallenge.lanchonete.infrastructure.controllers;

import com.techchallenge.lanchonete.application.dto.CheckoutDTO;
import com.techchallenge.lanchonete.application.usecases.CheckoutServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("checkout")
public class CheckoutController {
    private final CheckoutServiceImpl checkoutService;

    public CheckoutController(CheckoutServiceImpl checkoutService) {
        this.checkoutService = checkoutService;
    }

    @GetMapping(value = "/listar")
    List<CheckoutDTO> checkout() {
        return checkoutService.buscar();
    }
}
