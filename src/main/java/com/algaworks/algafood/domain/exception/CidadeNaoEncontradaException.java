package com.algaworks.algafood.domain.exception;

public class CidadeNaoEncontradaException extends EntidadeNaoEncontradaException {

    public static final String MSG_CIDADE_NAO_ENCONTRADA = "Não existe um cadastro de Cidade com o código '%d'";
    public CidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public CidadeNaoEncontradaException(Long id) {
        this(String.format(MSG_CIDADE_NAO_ENCONTRADA, id));
    }
}
