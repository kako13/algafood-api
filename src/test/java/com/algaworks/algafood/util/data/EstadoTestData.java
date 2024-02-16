package com.algaworks.algafood.util.data;

import com.algaworks.algafood.domain.model.Estado;

public class EstadoTestData {

    public static Estado.EstadoBuilder umEstadoExistente() {
        return Estado.builder()
                .id(1L)
                .nome("São Paulo");
    }
    public static Estado.EstadoBuilder umEstadoNovo() {
        return Estado.builder()
                .nome("São Paulo");
    }
}
