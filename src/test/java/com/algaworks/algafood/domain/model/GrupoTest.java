package com.algaworks.algafood.domain.model;

import com.algaworks.algafood.util.data.GruposTestData;
import com.algaworks.algafood.util.data.PermissaoTestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class GrupoTest {

    private Grupo grupo;
    private Permissao permissaoAtual;
    private Permissao permissaoNova;

    @BeforeEach
    void setUp() {
        this.prepararDados();
    }

    @Test
    void adicionarPermissao() {
        assertTrue(grupo.adicionarPermissao(permissaoNova));
        assertTrue(grupo.getPermissoes().contains(permissaoNova));
    }

    @Test
    void removerPermissao() {
        assertTrue(grupo.removerPermissao(permissaoAtual));
        assertFalse(grupo.getPermissoes().contains(permissaoAtual));
    }

    private void prepararDados() {
        grupo = GruposTestData.umGrupoNovo().build();
        permissaoAtual = grupo.getPermissoes().stream().findFirst().get();
        permissaoNova = PermissaoTestData.umaPermissaoExistente().id(2L).build();
    }
}