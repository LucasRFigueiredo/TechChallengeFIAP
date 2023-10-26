package com.techchallenge.lanchonete.produto.infra.entity;

import com.techchallenge.lanchonete.produto.domain.entity.Produto;
import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String tipo;
    private String nome;
    private String descricao;
    private Double preco;

    public ProdutoEntity(Produto produto) {
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
    }
}
