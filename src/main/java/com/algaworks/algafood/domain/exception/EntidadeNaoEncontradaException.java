package com.algaworks.algafood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

//@ResponseStatus(code = HttpStatus.NOT_FOUND) //reason = "Entidade não encontrada")
public class EntidadeNaoEncontradaException extends ResponseStatusException {
    public EntidadeNaoEncontradaException(String mensagem) {
        this(HttpStatus.NOT_FOUND, mensagem);
    }

    public EntidadeNaoEncontradaException(HttpStatusCode status, String mensagem) {
        super(status, mensagem);
    }
}
