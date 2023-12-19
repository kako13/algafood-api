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

    public void calcularPrecoTotal() {
        BigDecimal precoUnitario = this.getPrecoUnitario();
        Integer quantidade = this.getQuantidade();

        if (precoUnitario == null)
            precoUnitario = BigDecimal.ZERO;

        if (quantidade == null)
            quantidade = 0;

        this.precoTotal = precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

    public void definirValorUnitario() {
        this.precoUnitario = getProduto().getPreco();
    }
}
