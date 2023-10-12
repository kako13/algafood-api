package com.algaworks.algafood;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@SpringBootTest
class CadastroCozinhaIntegrationTests {

	@Autowired
	private CadastroCozinhaService cadastroCozinha;

	@Test
	public void testarCadastroCozinhaComSucesso() {
		//cenario
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome("Chinesa");
		//ação
		novaCozinha = cadastroCozinha.salvar(novaCozinha);
		//validação
		assertThat(novaCozinha).isNotNull();
		assertThat(novaCozinha.getId()).isNotNull();
	}

	@Test
	public void testarCadastroCozinhaSemNome_MinhaSugestao() {
		//cenario
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome(null);
		//ação e validação
		assertThatThrownBy(() -> {
			cadastroCozinha.salvar(novaCozinha);
		}).isInstanceOf(ConstraintViolationException.class).isNotNull();
	}

	@Test
	public void testarCadastroCozinhaSemNome_SugestaoAlgaworks() {
		//cenario
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome(null);
		//ação e validação
		ConstraintViolationException erroEsperado =
				Assertions.assertThrows(ConstraintViolationException.class, () -> {
					cadastroCozinha.salvar(novaCozinha);
				});
		//validação
		assertThat(erroEsperado).isNotNull();
	}
}
