package com.algaworks.algafood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NegocioExceptionException extends RuntimeException {
    public NegocioExceptionException(String mensagem) {
        super(mensagem);
    }

    public NegocioExceptionException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
