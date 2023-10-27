package com.techchallenge.lanchonete.produto.domain.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {
    private Long Id;
    private String tipo;
    private String nome;
    private String descricao;
    private Double preco;
}
