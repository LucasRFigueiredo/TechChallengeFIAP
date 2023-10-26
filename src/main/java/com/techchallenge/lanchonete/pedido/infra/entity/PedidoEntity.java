package com.techchallenge.lanchonete.pedido.infra.entity;

import com.techchallenge.lanchonete.cliente.infra.entity.ClienteEntity;
import com.techchallenge.lanchonete.pedido.domain.entity.Pedido;
import com.techchallenge.lanchonete.produto.infra.entity.ProdutoEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pedidos")
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private ClienteEntity cliente;
    private String status;
    private List<ProdutoEntity> itens;

    public PedidoEntity() {
    }
    //TODO fazer mappers separados dessa parte
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
