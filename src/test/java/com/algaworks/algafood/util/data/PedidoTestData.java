package com.algaworks.algafood.util.data;

import com.algaworks.algafood.domain.model.ItemPedido;
import com.algaworks.algafood.domain.model.Pedido;
import com.algaworks.algafood.domain.model.StatusPedido;

import java.math.BigDecimal;
import java.util.List;

public class PedidoTestData {

    public static Pedido.PedidoBuilder umPedidoNovo() {
        List<ItemPedido> itens = prepararItens();
        return Pedido.builder()
//                .subtotal(BigDecimal.valueOf(110.00))
                .taxaFrete(BigDecimal.valueOf(10))
//                .valorTotal(BigDecimal.valueOf(120))
                .status(StatusPedido.CRIADO)
                .endereco(EnderecoTestData.umEndereco().build())
                .itens(itens)
                ;
    }

    private static List<ItemPedido> prepararItens() {
        return List.of(ItemPedidoTestData.umItemNovo().build());
    }
}
