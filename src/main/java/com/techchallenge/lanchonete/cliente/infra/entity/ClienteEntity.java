package com.techchallenge.lanchonete.cliente.infra.entity;


import com.techchallenge.lanchonete.pedido.infra.entity.PedidoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<PedidoEntity> pedidos;

    /*public ClienteEntity(Cliente cliente){
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
    }

    public void atualizar(Cliente cliente){
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
    }

    public Cliente toCliente(){
        return new Cliente(this.id, this.nome, this.cpf, this.email);
    }*/
}
