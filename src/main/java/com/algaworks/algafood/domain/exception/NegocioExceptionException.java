package com.algaworks.algafood.domain.exception;

public class NegocioExceptionException extends RuntimeException {
    public NegocioExceptionException(String mensagem) {
        super(mensagem);
    }

    public NegocioExceptionException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
