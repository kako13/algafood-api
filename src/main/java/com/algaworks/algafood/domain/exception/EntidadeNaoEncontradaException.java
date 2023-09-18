package com.algaworks.algafood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EntidadeNaoEncontradaException extends NegocioExceptionException {
    public EntidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
