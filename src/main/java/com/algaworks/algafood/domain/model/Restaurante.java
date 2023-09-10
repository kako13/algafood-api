package com.algaworks.algafood.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

//    @JsonIgnore
    @JoinColumn(name = "cozinha_id", nullable = false) //"num_idt_cozinha" definindo nome da coluna
    @ManyToOne
    private Cozinha cozinha;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "relacao_restaurante_forma_pagamento",
            joinColumns = @JoinColumn(name = "restaurante"),
            inverseJoinColumns = @JoinColumn(name = "forma_pagamento"))
    private List<FormaPagamento> formasPagamento = new ArrayList<>();

    @Embedded
    private Endereco endereco;
}
