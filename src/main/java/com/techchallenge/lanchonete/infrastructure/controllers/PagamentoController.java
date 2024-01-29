package com.techchallenge.lanchonete.infrastructure.controllers;

import com.techchallenge.lanchonete.application.usecases.PagamentoServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pagamento")
public class PagamentoController {
    private final PagamentoServiceImpl pagamentoService;

    public PagamentoController(PagamentoServiceImpl pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @GetMapping(value = "/aprovar/{id}")
    void aprovar(@PathVariable Long id) {
        pagamentoService.aprovar(id);
    }

    @GetMapping(value = "/reprovar/{id}")
    void reprovar(@PathVariable Long id) {
        pagamentoService.reprovar(id);
    }
}

