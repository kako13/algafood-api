package com.algaworks.algafood.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurante {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(name = "taxa_frete", nullable = false)
    private BigDecimal taxaFrete;

    @JoinColumn(name = "cozinha_id", nullable = false) //"num_idt_cozinha" definindo nome da coluna
    @ManyToOne
    private Cozinha cozinha;

//    @JoinColumn(nullable = false)
//    @ManyToOne
//    private FormaPagamento formaPagamento;
}
