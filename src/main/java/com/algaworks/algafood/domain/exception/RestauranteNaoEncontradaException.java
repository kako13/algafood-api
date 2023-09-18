package com.algaworks.algafood.domain.exception;

public class RestauranteNaoEncontradaException extends EntidadeNaoEncontradaException {

    public static final String MSG_RESTAURANTE_NAO_ENCONTRADO = "Não existe cadastro de restaurante com o código %d";
    public RestauranteNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public RestauranteNaoEncontradaException(Long id) {
        this(String.format(MSG_RESTAURANTE_NAO_ENCONTRADO, id));
    }
}
