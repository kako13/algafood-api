package com.algaworks.algafood.util.data;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Endereco;

public class CidadeTestData {

    public static Cidade.CidadeBuilder umaCidadeExistente() {
        return Cidade.builder()
                .id(1L)
                .nome("Barueri")
                .estado(EstadoTestData.umEstadoExistente().build());
    }
    public static Cidade.CidadeBuilder umaCidadeNova() {
        return Cidade.builder()
                .nome("Barueri")
                .estado(EstadoTestData.umEstadoNovo().build());
    }
}
