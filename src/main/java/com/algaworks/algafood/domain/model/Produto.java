package com.algaworks.algafood.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Produto {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private BigDecimal preco;
    @Column(nullable = false)
    private boolean ativo;

    @JoinColumn(name = "restaurante_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurante restaurante;
}
