package com.algaworks.algafood.domain.exception;

public abstract class EntidadeNaoEncontradaException extends NegocioExceptionException {
    protected EntidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
