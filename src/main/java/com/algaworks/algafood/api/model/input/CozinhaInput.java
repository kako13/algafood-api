package com.algaworks.algafood.api.model.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CozinhaInput {

    @NotBlank
    private String nome;
}
