package com.algaworks.algafood.util.data;

import com.algaworks.algafood.domain.model.Endereco;

public class EnderecoTestData {

    public static Endereco.EnderecoBuilder umEndereco() {
        return Endereco.builder()
                .cep("06192-070")
                .bairro("Jd. Tupancy")
                .logradouro("Rua João Pinheiro")
                .numero("1000")
                .cidade(CidadeTestData.umaCidadeNova().build());
    }
}
