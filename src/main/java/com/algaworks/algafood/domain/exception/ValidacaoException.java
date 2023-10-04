package com.algaworks.algafood.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.BindingResult;

@Getter
@AllArgsConstructor
public class ValidacaoException extends RuntimeException {
    private BindingResult bindingResult;
}
