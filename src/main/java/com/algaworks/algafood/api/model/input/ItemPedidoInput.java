package com.algaworks.algafood.api.model.input;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedidoInput {

    @NotNull
    private Long produtoId;
    @PositiveOrZero
    @NotNull
    private Integer quantidade;
    private String observacao;
}
