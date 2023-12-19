package com.algaworks.algafood.domain.model;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public enum StatusPedido {
    CRIADO("Criado"),
    CONFIRMADO("Confirmado", CRIADO),
    ENTREGUE("Entregue", CONFIRMADO),
    CANCELADO("Cancelado", CRIADO, CONFIRMADO);

    @Getter
    private final String descricao;

    private final List<StatusPedido> statusAnteriores;

    StatusPedido(String descricao, StatusPedido... statusAnteriores) {
        this.statusAnteriores = Arrays.asList(statusAnteriores);
        this.descricao = descricao;
    }

    public boolean naoPodeAlterarPara(StatusPedido novoStatus) {
        return !novoStatus.statusAnteriores.contains(this);
    }
}