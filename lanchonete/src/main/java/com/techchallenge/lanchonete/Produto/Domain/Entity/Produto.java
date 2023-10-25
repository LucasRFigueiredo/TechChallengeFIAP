package com.techchallenge.lanchonete.Produto.Domain.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    private String tipo;
    private String nome;
    private String descricao;
    private Double preco;
}
