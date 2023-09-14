package com.algaworks.algafood.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class ItemPedido {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer quantidade;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precoUnitario;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precoTotal;
    private String observacao;

    @JoinColumn(nullable = false, unique = true)
    @ManyToOne
    private Pedido pedido;

    @JoinColumn(nullable = false, unique = true)
    @ManyToOne
    private Produto produto;
}
