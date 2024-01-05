package com.algaworks.algafood.domain.model;

import com.algaworks.algafood.util.data.GruposTestData;
import com.algaworks.algafood.util.data.UsuarioTestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class UsuarioTest {

    private Usuario usuarioExistente;
    private Usuario usuarioNovo;
    private Grupo grupoAtual;
    private Grupo grupoNovo;

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
        assertTrue(usuarioExistente.adicionarGrupo(grupoNovo));
    }

    @Test
    void removerGrupo() {
        assertTrue(usuarioExistente.removerGrupo(grupoAtual));
    }

    private void prepararDados() {
        usuarioExistente = UsuarioTestData.umUsuarioExistente().build();
        usuarioNovo = UsuarioTestData.umUsuarioNovo().build();
        grupoNovo = GruposTestData.umGrupoNovo().build();
        grupoAtual = usuarioExistente.getGrupos().stream().findFirst().get();
    }
}