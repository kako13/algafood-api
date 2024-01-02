package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.model.input.CidadeInput;
import com.algaworks.algafood.api.model.input.EstadoIdInput;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.util.data.CidadeTestData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CidadeInputDisassemblerTest {

    private static CidadeInput cidadeInput;
    private static EstadoIdInput estadoIdInput;
    @Autowired
    private CidadeInputDisassembler cidadeInputDisassembler;

    @BeforeEach
    void setup () {
        prepararDados();
    }

    @Test
    void testarToDomainObject() {
        Cidade domainObject = cidadeInputDisassembler.toDomainObject(cidadeInput);
        Assertions.assertThat(domainObject)
                .isNotNull()
                .isInstanceOf(Cidade.class)
                .hasAllNullFieldsOrPropertiesExcept("nome", "estado")
                .extracting("estado.id", "nome")
                .containsExactly(cidadeInput.getEstado().getId(), cidadeInput.getNome())
        ;
    }

    @Test
    void testarCopyToDomainObject() {
        Cidade cidadeBarueri = CidadeTestData.umaCidadeExistente().build();
        cidadeInputDisassembler.copyToDomainObject(cidadeInput, cidadeBarueri);
        Assertions.assertThat(cidadeBarueri)
                .isNotNull()
                .isInstanceOf(Cidade.class)
                .hasAllNullFieldsOrPropertiesExcept("id", "nome", "estado")
                .extracting("id", "estado.id", "nome")
                .containsExactly(cidadeBarueri.getId(), cidadeInput.getEstado().getId(), cidadeInput.getNome())
        ;
    }

    private static CidadeInput prepararDados() {
        cidadeInput = new CidadeInput();
        cidadeInput.setNome("São Lourenço da Serra");

        estadoIdInput = new EstadoIdInput();
        estadoIdInput.setId(1L);
        cidadeInput.setEstado(estadoIdInput);
        return cidadeInput;
    }

}