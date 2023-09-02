package com.algaworks.algafood.jpa.estado;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaEstadoMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        EstadoRepository estados = applicationContext.getBean(EstadoRepository.class);

        List<Estado> todosEstados = estados.listar();
        todosEstados.forEach(e -> System.out.println(e.getNome()));
    }
}
