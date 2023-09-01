package com.algaworks.algafood.jpa.restaurante;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

public class AlteracaoRestauranteMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepository cadastroCozinha = applicationContext.getBean(RestauranteRepository.class);

        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Casa das esfihas");
        restaurante.setTaxaFrete(BigDecimal.valueOf(12.35));
        restaurante.setId(1L);

        restaurante = cadastroCozinha.salvar(restaurante);

        System.out.printf("%d - %s \n", restaurante.getId(), restaurante.getNome());
    }
}
