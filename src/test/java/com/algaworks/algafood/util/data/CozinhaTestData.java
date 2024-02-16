package com.algaworks.algafood.util.data;

import com.algaworks.algafood.domain.model.Cozinha;

public class CozinhaTestData {

    public static Cozinha.CozinhaBuilder umaCozinhaNova() {
        return Cozinha.builder()
                .nome("Brasileira");
    }
    public static Cozinha.CozinhaBuilder umaCozinhaExistente() {
        return Cozinha.builder()
                .id(1L)
                .nome("Brasileira");
    }
}
