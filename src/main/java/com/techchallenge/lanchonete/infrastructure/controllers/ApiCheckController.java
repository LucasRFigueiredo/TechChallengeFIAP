package com.techchallenge.lanchonete.infrastructure.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("healthcheck")
public class ApiCheckController {

    @GetMapping(value = "/health")
    String checkout() {
        return "API up";
    }
}
