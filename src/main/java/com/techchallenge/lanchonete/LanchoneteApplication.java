package com.techchallenge.lanchonete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.techchallenge.lanchonete.pedido.infra.entity", "com.techchallenge.lanchonete.cliente.infra.entity", "com.techchallenge.lanchonete.produto.infra.entity"})
public class LanchoneteApplication {

    public static void main(String[] args) {
        SpringApplication.run(LanchoneteApplication.class, args);
    }

}
