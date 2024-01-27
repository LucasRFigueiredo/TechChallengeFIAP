package com.techchallenge.lanchonete.infrastructure.controllers;

import com.techchallenge.lanchonete.application.dto.CheckoutDTO;
import com.techchallenge.lanchonete.application.usecases.CheckoutServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("checkout")
public class CheckoutController {
    private final CheckoutServiceImpl checkoutService;

    public CheckoutController(CheckoutServiceImpl checkoutService) {
        this.checkoutService = checkoutService;
    }

    @GetMapping(value = "/{id}")
    CheckoutDTO checkout(@PathVariable Long id) {
        return checkoutService.buscar(id);
    }
}
