package com.algaworks.algafood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public abstract class EntidadeNaoEncontradaException extends NegocioExceptionException {
    protected EntidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
