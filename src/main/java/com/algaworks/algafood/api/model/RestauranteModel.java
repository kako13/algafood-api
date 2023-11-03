package com.algaworks.algafood.api.model;

import lombok.*;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestauranteModel {

    private Long id;

    private String nome;

    private BigDecimal frete;

    private CozinhaModel cozinha;

    /*
    * É dividido em Tokens
    * Origem: cozinha, nome
    * Destino: nome, cozinha
    *
    */
    private String nomeCozinha;
    private String idCozinha;
}
