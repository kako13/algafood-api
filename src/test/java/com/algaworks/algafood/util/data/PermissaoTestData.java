package com.algaworks.algafood.util.data;

import com.algaworks.algafood.domain.model.Permissao;

public class PermissaoTestData {

    public static Permissao.PermissaoBuilder umaPermissaoExistente() {
        return Permissao.builder()
                .id(1L)
                .nome("ACESSO TOTAL")
                .descricao("Permite o acesso completo à todas as features")
                ;
    }
}
