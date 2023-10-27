package com.techchallenge.lanchonete.pedido.infra.entity;

import com.techchallenge.lanchonete.cliente.infra.entity.ClienteEntity;
import com.techchallenge.lanchonete.produto.infra.entity.ProdutoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Pedido")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "Cliente_id")
    private ClienteEntity cliente;
    private String status;

    @ManyToMany
    @JoinTable(name = "Pedido_Produto",
            joinColumns = @JoinColumn(name = "Pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "Produto_id"))
    private List<ProdutoEntity> produtos;

    //TODO fazer mappers separados dessa parte

    /*public void atualizar(Pedido pedido) {
        this.id = pedido.getId();
        this.cliente = pedido.getCliente();
        this.status = pedido.getStatus();
        this.itens = pedido.getItens();
    }*/

    /*public Pedido toPedido() {
        return new Pedido(this.id, this.cliente, this.status, this.itens);
    }*/
}
