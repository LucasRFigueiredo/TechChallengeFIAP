package com.techchallenge.lanchonete.produto.domain.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProdutoDto {
    private Long Id;
    private String tipo;
    private String nome;
    private String descricao;
    private Double preco;
}
