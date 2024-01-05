package com.algaworks.algafood.domain.model;

import com.algaworks.algafood.util.data.PedidoTestData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class PedidoTest {

    private Pedido pedido;

    @BeforeEach
    void setUp() {
        this.prepararDados();
    }

    @Test
    void calcularValorTotal() {
        pedido.calcularValorTotal();
        BigDecimal taxaFrete = pedido.getTaxaFrete();
        BigDecimal subtotal = pedido.getSubtotal();
        Assertions.assertThat(pedido.getValorTotal())
                .isPositive()
                .isEqualTo(taxaFrete.add(subtotal))
        ;
    }

    @Test
    void confirmar() {
        pedido.confirmar();
        Assertions.assertThat(pedido.getStatus())
                .isEqualTo(StatusPedido.CONFIRMADO);
    }

    @Test
    void cancelar() {
        pedido.cancelar();
        Assertions.assertThat(pedido.getStatus())
                .isEqualTo(StatusPedido.CANCELADO);
    }

    @Test
    void entregar() {
        pedido.confirmar();
        pedido.entregar();
        Assertions.assertThat(pedido.getStatus())
                .isEqualTo(StatusPedido.ENTREGUE);
    }

    private void prepararDados() {
        pedido = PedidoTestData.umPedidoNovo().build();
    }
}