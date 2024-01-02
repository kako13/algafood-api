package com.algaworks.algafood.util.data;

import com.algaworks.algafood.domain.model.Grupo;

import java.util.Set;

public class GruposTestData {

    public static Grupo.GrupoBuilder umGrupoNovo() {
        return Grupo.builder()
                .nome("Desenvolvedor")
                .permissoes(Set.of(PermissaoTestData.umaPermissaoNova().build()))
                ;
    }
}
