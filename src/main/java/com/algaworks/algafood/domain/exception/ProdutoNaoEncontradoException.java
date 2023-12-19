package com.algaworks.algafood.domain.exception;

public class ProdutoNaoEncontradoException extends EntidadeNaoEncontradaException {

    public static final String MSG_PRODUTO_NAO_ENCONTRADO = "Não existe um cadastro de produto com código %d para o restaurante de código %d";

    public ProdutoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public ProdutoNaoEncontradoException(Long restauranteId, Long produtoId) {
        this(String.format(MSG_PRODUTO_NAO_ENCONTRADO,
                produtoId, restauranteId));
    }
}
