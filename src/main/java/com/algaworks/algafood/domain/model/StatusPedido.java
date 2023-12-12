package com.algaworks.algafood.domain.model;

import lombok.Getter;

public enum StatusPedido {
    CRIADO("Criado"),
    CONFIRMADO("Confirmado"),
    ENTREGUE("Entregue"),
    CANCELADO("Cancelado");

    @Getter
    private final String descricao;

    StatusPedido(String descricao) {
        this.descricao = descricao;
    }
}