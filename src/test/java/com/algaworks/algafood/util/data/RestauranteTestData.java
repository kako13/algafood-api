package com.algaworks.algafood.util.data;

import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.model.Usuario;

import java.math.BigDecimal;
import java.util.HashSet;

public class RestauranteTestData {

    public static Restaurante.RestauranteBuilder umRestauranteNovo() {
        HashSet<Usuario> responsaveis = new HashSet<>();
        responsaveis.add(UsuarioTestData.umUsuarioNovo().build());
        HashSet<FormaPagamento> fomasPagamento = new HashSet<>();
        fomasPagamento.add(FormaPagamentoTestData.umaFormaPagamentoNova().build());
        return Restaurante.builder()
                .nome("Casa da Feijoada")
                .taxaFrete(BigDecimal.TEN)
                .aberto(Boolean.FALSE)
                .ativo(Boolean.FALSE)
                .cozinha(CozinhaTestData.umaCozinhaNova().build())
                .endereco(EnderecoTestData.umEndereco().build())
                .responsaveis(responsaveis)
                .formasPagamento(fomasPagamento
                )
                ;
    }
}
