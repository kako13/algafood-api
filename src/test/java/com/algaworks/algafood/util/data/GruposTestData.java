package com.algaworks.algafood.util.data;

import com.algaworks.algafood.domain.model.Grupo;
import com.algaworks.algafood.domain.model.Permissao;

import java.util.HashSet;
import java.util.Set;

public class GruposTestData {

    private static Set<Permissao> permissoes;

    public static Grupo.GrupoBuilder umGrupoNovo() {
        permissoes = prepararPermissoes();
        return Grupo.builder()
                .nome("Desenvolvedor")
                .permissoes(permissoes)
                ;
    }

    public static Grupo.GrupoBuilder umGrupoExistente() {
        permissoes = prepararPermissoes();
        return Grupo.builder()
                .id(1L)
                .nome("Gerente")
                .permissoes(permissoes)
                ;
    }

    private static Set<Permissao> prepararPermissoes() {
        Set<Permissao> permissoes = new HashSet<>();
        permissoes.add(PermissaoTestData.umaPermissaoExistente().build());
        return permissoes;
    }
}
