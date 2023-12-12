package com.algaworks.algafood.api.model.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PedidoInput {

    @NotNull
    @Valid
    private RestauranteIdInput restaurante;
    @NotNull
    @Valid
    private FormaPagamentoIdInput formaPagamento;
    @NotNull
    @Valid
    private EnderecoInput enderecoEntrega;
    @NotNull
    @Size(min = 1)
    @Valid
    private List<ItemPedidoInput> itens = new ArrayList<>();
}
