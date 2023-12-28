package com.algaworks.algafood.api.model.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class RestauranteInput {

    @NotBlank
    private String nome;

    @NotNull
    @PositiveOrZero
    private BigDecimal taxaFrete;

    @Valid
    @NotNull
    private CozinhaIdInput cozinha;

    @Valid
    @NotNull
    private EnderecoInput endereco;

    public RestauranteInput() {
    }

    public RestauranteInput(String nome, BigDecimal taxaFrete, Long cozinha, EnderecoInput endereco) {
        this.nome = nome;
        this.taxaFrete = taxaFrete;
        CozinhaIdInput cozinhaIdInput = new CozinhaIdInput();
        cozinhaIdInput.setId(cozinha);
        this.cozinha = cozinhaIdInput;
        this.endereco = endereco;
    }
}
