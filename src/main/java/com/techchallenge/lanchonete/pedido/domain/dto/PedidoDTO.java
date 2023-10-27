package com.techchallenge.lanchonete.pedido.domain.dto;

import com.techchallenge.lanchonete.cliente.domain.dto.ClienteDTO;
import com.techchallenge.lanchonete.produto.domain.Dto.ProdutoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
    private Long id;
    private ClienteDTO cliente;
    private String status;
    private List<ProdutoDTO> itens;
}
