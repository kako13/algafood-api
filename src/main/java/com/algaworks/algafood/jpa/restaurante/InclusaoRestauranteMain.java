package com.algaworks.algafood.jpa.restaurante;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.util.List;

public class InclusaoRestauranteMain {
    public static void main(String[] args) {
        ApplicationContext aplicationaContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepository repository = aplicationaContext.getBean(RestauranteRepository.class);

        Restaurante restaurante1 = new Restaurante();
        restaurante1.setNome("Restaurante Brasilidades");
        restaurante1.setTaxaFrete(BigDecimal.valueOf(3.5));

        Restaurante restaurante2 = new Restaurante();
        restaurante2.setNome("Restaurante Feijoda Top");
        restaurante2.setTaxaFrete(BigDecimal.valueOf(6.5));

        restaurante1 = repository.salvar(restaurante1);
        restaurante2 = repository.salvar(restaurante2);

        List.of(restaurante1, restaurante2).forEach(System.out::println);
    }
}
