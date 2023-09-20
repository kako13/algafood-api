package com.algaworks.algafood.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    ENTIDADE_NAO_ENCONTRADA("/entidade-nao-encontrada", "Entidade não encontrada");

    private final String title;
    private final String uri;

    ProblemType(String path, String title) {
        this.uri = "https://algafood.com.br"+path;
        this.title = title;
    }
}
