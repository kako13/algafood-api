package com.algaworks.algafood.domain.model;

import com.algaworks.algafood.util.data.ItemPedidoTestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemPedidoTest {

    private ItemPedido itemPedido;

    @BeforeEach
    void setUp() {
        this.prepararDados();
    }

    @Test
    void calcularPrecoTotal() {
        itemPedido.definirValorUnitario();
        itemPedido.calcularPrecoTotal();
        BigDecimal precoUnitario = itemPedido.getPrecoUnitario();
        assertEquals(itemPedido.getPrecoTotal(), precoUnitario.multiply(BigDecimal.valueOf(itemPedido.getQuantidade())));
    }

    @Test
    void definirValorUnitario() {
        itemPedido.definirValorUnitario();
        assertEquals(itemPedido.getPrecoUnitario(), itemPedido.getProduto().getPreco());
    }

    private void prepararDados() {
        itemPedido = ItemPedidoTestData.umItemNovo().build();
    }
}