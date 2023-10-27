package com.techchallenge.lanchonete.produto.infra.entity;

import com.techchallenge.lanchonete.pedido.infra.entity.PedidoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String tipo;
    private String nome;
    private String descricao;
    private Double preco;

    @ManyToMany(mappedBy = "produtos")
    private List<PedidoEntity> pedidos;

    /*public ProdutoEntity(Produto produto) {
        this.Id = produto.getId();
        this.tipo = produto.getTipo();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
    }

    public ProdutoEntity atualizar(Produto produto) {
        this.Id = produto.getId();
        this.tipo = produto.getTipo();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        return this;
    }

    public Produto toProduto() {
        return new Produto(this.Id, this.tipo, this.nome, this.descricao, this.preco);
    }*/
}
