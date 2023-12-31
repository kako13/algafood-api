package com.algaworks.algafood.domain.exception;

public class PedidoNaoEncontradoException extends EntidadeNaoEncontradaException {

    public static final String MSG_PEDIDO_NAO_ENCONTRADO = "Não existe um pedido com o código %s";

    public PedidoNaoEncontradoException(String codigo) {
        super(String.format(MSG_PEDIDO_NAO_ENCONTRADO, codigo));
    }
}
