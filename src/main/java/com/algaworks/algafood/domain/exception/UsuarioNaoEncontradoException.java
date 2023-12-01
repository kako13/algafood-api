package com.algaworks.algafood.domain.exception;

public class UsuarioNaoEncontradoException extends EntidadeNaoEncontradaException {

    public static final String MSG_USUARIO_NAO_ENCONTRADA = "Não existe cadastro de usuário com o nome %d";

    protected UsuarioNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public UsuarioNaoEncontradoException(Long idUsuario) {
        this(String.format(MSG_USUARIO_NAO_ENCONTRADA, idUsuario));
    }
}
