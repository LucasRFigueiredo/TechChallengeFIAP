package com.techchallenge.lanchonete.infrastructure.persistence.entity;


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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_gen")
    @SequenceGenerator(name = "users_seq_gen", sequenceName = "cliente_seq", allocationSize = 1)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<PedidoEntity> pedidos;
}
