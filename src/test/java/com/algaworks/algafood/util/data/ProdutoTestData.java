package com.algaworks.algafood.util.data;

import com.algaworks.algafood.domain.model.Produto;

import java.math.BigDecimal;

public class ProdutoTestData {
    public static Produto.ProdutoBuilder umProdutoNovo() {
        return Produto.builder()
                .nome("Bife à cavalo")
                .descricao("Arroz, feijão, bife de contra filé e ovo frito")
                .preco(BigDecimal.valueOf(35.5))
                .ativo(Boolean.TRUE)
                ;
    }
}
