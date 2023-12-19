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
    private Integer quantidade;
    private BigDecimal precoUnitario;
    private BigDecimal precoTotal;
    private String observacao;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Pedido pedido;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Produto produto;
}
