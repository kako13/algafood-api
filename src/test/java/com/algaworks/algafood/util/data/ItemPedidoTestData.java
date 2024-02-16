package com.algaworks.algafood.util.data;

import com.algaworks.algafood.domain.model.ItemPedido;

public class ItemPedidoTestData {

    public static ItemPedido.ItemPedidoBuilder umItemNovo() {
        return ItemPedido.builder()
                .quantidade(1)
//                .precoUnitario(BigDecimal.valueOf(4.5))
                .observacao("Item de teste")
                .produto(ProdutoTestData.umProdutoNovo().build())
                ;
    }
}
