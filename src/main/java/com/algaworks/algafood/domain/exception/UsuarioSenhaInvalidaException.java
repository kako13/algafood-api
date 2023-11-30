package com.algaworks.algafood.domain.exception;

public class UsuarioSenhaInvalidaException extends NegocioException {

    public static final String MSG_USUARIO_SENHA_INVALIDA = "Senha atual informada não coincide com a senha cadastrada para o usuário '%s'.";

    public UsuarioSenhaInvalidaException(String usuario) {
        super(String.format(MSG_USUARIO_SENHA_INVALIDA, usuario));
    }
}
