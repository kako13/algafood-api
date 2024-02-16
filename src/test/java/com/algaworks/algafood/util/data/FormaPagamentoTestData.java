package com.algaworks.algafood.util.data;

import com.algaworks.algafood.domain.model.FormaPagamento;

public class FormaPagamentoTestData {

    public static FormaPagamento.FormaPagamentoBuilder umaFormaPagamentoNova () {
        return FormaPagamento.builder()
                .descricao("Pix")
                ;
    }
    public static FormaPagamento.FormaPagamentoBuilder umaFormaPagamentoExistente () {
        return FormaPagamento.builder()
                .id(1L)
                .descricao("Cartão de crédito")
                ;
    }
}
