package com.algaworks.algafood.util.data;

import com.algaworks.algafood.domain.model.Grupo;
import com.algaworks.algafood.domain.model.Usuario;

import java.util.HashSet;
import java.util.Set;

public class UsuarioTestData {

    public static Usuario.UsuarioBuilder umUsuarioNovo() {
        Set<Grupo> grupos = prepararGrupos();
        return Usuario.builder()
                .nome("João D")
                .email("joao.d.dev@algafood")
                .senha("123456")
                .grupos(grupos)
                ;
    }

    public static Usuario.UsuarioBuilder umUsuarioExistente() {
        Set<Grupo> grupos = prepararGrupos();
        return Usuario.builder()
                .id(1L)
                .nome("Jonas F")
                .email("Jonas.f.dev@algafood")
                .senha("654321")
                .grupos(grupos)
                ;
    }

    private static Set<Grupo> prepararGrupos() {
        Set<Grupo> grupos = new HashSet<>();
        grupos.add(GruposTestData.umGrupoExistente().build());
        return grupos;
    }
}
