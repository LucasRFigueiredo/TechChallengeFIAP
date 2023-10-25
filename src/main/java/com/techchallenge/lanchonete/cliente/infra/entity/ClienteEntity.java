package com.techchallenge.lanchonete.cliente.infra.entity;


import com.techchallenge.lanchonete.cliente.domain.entity.Cliente;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "clientes")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String cpf;
    private String email;

    public ClienteEntity(){
    }

    public ClienteEntity(Cliente cliente){
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
    }
}
