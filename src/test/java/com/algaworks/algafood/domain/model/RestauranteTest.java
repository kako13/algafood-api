package com.algaworks.algafood.domain.model;

import com.algaworks.algafood.util.data.FormaPagamentoTestData;
import com.algaworks.algafood.util.data.RestauranteTestData;
import com.algaworks.algafood.util.data.UsuarioTestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestauranteTest {

    private Restaurante restauranteCasaDaFeijoda;
    private FormaPagamento credito;
    private FormaPagamento debito;
    private Usuario usuarioResponsavel;

    @BeforeEach
    void setup() {
        prepararRestaurante();
    }

    @Test
    void testarAtivar() {
        restauranteCasaDaFeijoda.ativar();
        assertEquals(Boolean.TRUE, restauranteCasaDaFeijoda.getAtivo());
    }

    @Test
    void testarInativar() {
        restauranteCasaDaFeijoda.inativar();
        assertEquals(Boolean.FALSE, restauranteCasaDaFeijoda.getAtivo());
    }

    @Test
    void testarRemoverFormaPagamento() {
        assertTrue(restauranteCasaDaFeijoda.removerFormaPagamento(credito));
        Set<FormaPagamento> formasPagamento = restauranteCasaDaFeijoda.getFormasPagamento();
        assertEquals(Boolean.FALSE, formasPagamento.contains(credito));
    }

    @Test
    void testarAdicionarFormaPagamento() {
        assertTrue(restauranteCasaDaFeijoda.adicionarFormaPagamento(debito));
        Set<FormaPagamento> formasPagamento = restauranteCasaDaFeijoda.getFormasPagamento();
        assertEquals(Boolean.TRUE, formasPagamento.contains(debito));
    }

    @Test
    void testarAbrir() {
        restauranteCasaDaFeijoda.abrir();
        assertEquals(Boolean.TRUE, restauranteCasaDaFeijoda.getAberto());
    }

    @Test
    void fechar() {
        restauranteCasaDaFeijoda.fechar();
        assertEquals(Boolean.FALSE, restauranteCasaDaFeijoda.getAberto());
    }

    @Test
    void removerResponsavel() {
        assertTrue(restauranteCasaDaFeijoda.removerResponsavel(usuarioResponsavel));
        Set<Usuario> responsaveis = restauranteCasaDaFeijoda.getResponsaveis();
        assertEquals(Boolean.FALSE, responsaveis.contains(usuarioResponsavel));
    }

    @Test
    void adicionarResponsavel() {
        restauranteCasaDaFeijoda.getResponsaveis().clear();
        assertTrue(restauranteCasaDaFeijoda.adicionarResponsavel(usuarioResponsavel));
        Set<Usuario> responsaveis = restauranteCasaDaFeijoda.getResponsaveis();
        assertEquals(Boolean.TRUE, responsaveis.contains(usuarioResponsavel));
    }

    @Test
    void aceitaFormaPagamento() {
        boolean aceitaFormaPagamento = restauranteCasaDaFeijoda.aceitaFormaPagamento(debito);
        assertEquals(Boolean.FALSE, aceitaFormaPagamento);
    }

    @Test
    void naoAceitaFormaPagamento() {
        boolean naoAceitaFormaPagamento = restauranteCasaDaFeijoda.naoAceitaFormaPagamento(debito);
        assertEquals(Boolean.TRUE, naoAceitaFormaPagamento);
    }

    private void prepararRestaurante() {
        restauranteCasaDaFeijoda = RestauranteTestData.umRestauranteNovo().build();
        credito = FormaPagamentoTestData.umaFormaPagamentoNova().build();
        debito = FormaPagamentoTestData.umaFormaPagamentoNova().id(2L).descricao("Débito").build();
        usuarioResponsavel = restauranteCasaDaFeijoda.getResponsaveis().stream().findFirst().get();
    }
}