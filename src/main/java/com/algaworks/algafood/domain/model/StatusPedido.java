package com.algaworks.algafood.domain.model;

import lombok.Getter;

public enum StatusPedido {
    CRIADO("Criado"),
    CONFIRMADO("Confirmardo"),
    ENQTREGUE("Entregue"),
    CANCELADO("Cancelado");

    @Getter
    private String descricao;

    StatusPedido(String descricao) {
        this.descricao = descricao;
    }
}