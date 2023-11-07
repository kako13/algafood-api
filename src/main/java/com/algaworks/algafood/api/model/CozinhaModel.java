package com.algaworks.algafood.api.model;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CozinhaModel {

    /*
     * É dividido em Tokens
     * Origem: cozinha, nome
     * Destino: cozinha, cozinha, nome
     *
     */

    private Long id;
    private String cozinhaNome;
}
