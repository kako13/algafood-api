package com.algaworks.algafood.util.data;

import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.model.Restaurante;

import java.math.BigDecimal;
import java.util.Set;

public class RestauranteTestData {

    public static Restaurante.RestauranteBuilder umRestauranteNovo() {
        return Restaurante.builder()
                .nome("Casa da Feijoada")
                .taxaFrete(BigDecimal.TEN)
                .aberto(Boolean.FALSE)
                .ativo(Boolean.FALSE)
                .cozinha(CozinhaTestData.umaCozinhaNova().build())
                .endereco(EnderecoTestData.umEndereco().build())
                .responsaveis(Set.of(UsuarioTestData.umUsuarioNovo().build()))
                .formasPagamento(Set.of(FormaPagamentoTestData.umaFormaPagamentoNova().id(1L).build()))
                ;
    }
}
