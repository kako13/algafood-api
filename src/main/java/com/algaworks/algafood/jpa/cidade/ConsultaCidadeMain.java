package com.algaworks.algafood.jpa.cidade;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaCidadeMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CidadeRepository cozinhas = applicationContext.getBean(CidadeRepository .class);

        List<Cidade> todasCidades = cozinhas.listar();
        todasCidades.forEach(e -> System.out.println(e.getNome()));
    }
}
