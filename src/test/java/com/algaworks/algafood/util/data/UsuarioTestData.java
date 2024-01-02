package com.algaworks.algafood.util.data;

import com.algaworks.algafood.domain.model.Usuario;

import java.util.Set;

public class UsuarioTestData {

    public static Usuario.UsuarioBuilder umUsuarioNovo() {
        return Usuario.builder()
                .nome("João D")
                .email("joao.d.dev@algafood")
                .senha("123456")
                .grupos(Set.of(GruposTestData.umGrupoNovo().build()))
                ;
    }
}
