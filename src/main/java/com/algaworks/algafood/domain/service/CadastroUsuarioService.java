package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.exception.UsuarioNaoEncontradoException;
import com.algaworks.algafood.domain.model.Usuario;
import com.algaworks.algafood.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CadastroUsuarioService {

    public static final String MSG_USUARIO_SENHA_INVALIDA = "Senha atual informada não coincide com a senha cadastrada para o usuário.";
    public static final String MSG_USUARIO_JA_CADASTRADO = "Já existe um usuário cadastrado com o e-mail %s";

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario usuario) {
        usuarioRepository.detached(usuario);
        validarUsuarioExistente(usuario);
        return usuarioRepository.save(usuario);
    }

    private void validarUsuarioExistente(Usuario usuario) {
        String email = usuario.getEmail();
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(email);
        if (usuarioExistente.isPresent() && !usuarioExistente.get().equals(usuario))
            throw new NegocioException(String.format(MSG_USUARIO_JA_CADASTRADO, email));
    }

    @Transactional
    public void alterarSenha(Long idUsuario, String senhaAtual, String novaSenha) {
        Usuario usuario = buscarOuFalhar(idUsuario);
        if (usuario.getSenhaNaoCoincideCom(senhaAtual))
            throw new NegocioException(MSG_USUARIO_SENHA_INVALIDA);
        usuario.setSenha(novaSenha);
    }

    public Usuario buscarOuFalhar(Long idUsuario) {
        return usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(idUsuario));
    }
}
