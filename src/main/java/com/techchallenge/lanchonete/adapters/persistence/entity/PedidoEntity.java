package com.techchallenge.lanchonete.adapters.persistence.entity;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ped_seq_gen")
    @SequenceGenerator(name = "ped_seq_gen", sequenceName = "pedido_seq", allocationSize = 1)
    private Long id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Cliente_id")
    private ClienteEntity cliente;
    private String status;

    @ManyToMany
    @JoinTable(name = "Pedido_Produto",
            joinColumns = @JoinColumn(name = "Pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "Produto_id"))
    private List<ProdutoEntity> produtos;
    @OneToOne(mappedBy = "pedido")
    private CheckoutEntity checkout;
}
