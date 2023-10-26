package com.techchallenge.lanchonete.pedido.infra.entity;

import com.techchallenge.lanchonete.pedido.domain.entity.Pedido;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pedidos")
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cliente;
    private String status;
    private List<String> itens;

    public PedidoEntity() {
    }

    public PedidoEntity(Pedido pedido) {
        this.id = pedido.getId();
        this.cliente = pedido.getCliente();
        this.status = pedido.getStatus();
        this.itens = pedido.getItens();
    }

    public void atualizar(Pedido pedido) {
        this.id = pedido.getId();
        this.cliente = pedido.getCliente();
        this.status = pedido.getStatus();
        this.itens = pedido.getItens();
    }

    public Pedido toPedido() {
        return new Pedido(this.id, this.cliente, this.status, this.itens);
    }
}
