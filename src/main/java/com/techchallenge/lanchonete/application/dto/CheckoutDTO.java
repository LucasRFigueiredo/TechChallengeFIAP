package com.techchallenge.lanchonete.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutDTO {
    private PedidoDTO pedido;
    private BigDecimal total;
}
