package com.algaworks.algafood.domain.exception;

public class GrupoNaoEncontradoException extends EntidadeNaoEncontradaException {

    public static final String MSG_GRUPO_NAO_ENCONTRADO = "Não existe cadastro de grupo com o código %d";
    public GrupoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public GrupoNaoEncontradoException(Long id) {
        this(String.format(MSG_GRUPO_NAO_ENCONTRADO, id));
    }
}
