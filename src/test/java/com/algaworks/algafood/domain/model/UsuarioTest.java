package com.algaworks.algafood.domain.model;

import com.algaworks.algafood.util.data.UsuarioTestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UsuarioTest {

    private Usuario usuarioExistente;
    private Usuario usuarioNovo;

    @BeforeEach
    void setUp() {
        this.prepararDados();
    }

    @Test
    void senhaCoincideCom() {
        assertTrue(usuarioExistente.senhaCoincideCom(usuarioExistente.getSenha()));
    }

    @Test
    void senhaNaoCoincideCom() {
        assertTrue(usuarioExistente.senhaNaoCoincideCom(usuarioNovo.getSenha()));

    }

    @Test
    void adicionarGrupo() {

    }

    @Test
    void removerGrupo() {
    }

    private void prepararDados() {
        usuarioExistente = UsuarioTestData.umUsuarioExistente().build();
        usuarioNovo = UsuarioTestData.umUsuarioNovo().build();

    }
}