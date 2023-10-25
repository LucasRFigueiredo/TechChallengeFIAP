package com.techchallenge.lanchonete.pedido.infra.entity;

import java.util.List;
import java.util.UUID;

//@Entity
//@Table(name = "pedidos")
public class PedidoEntity {
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String cliente;
    private List<String> itens;
}
