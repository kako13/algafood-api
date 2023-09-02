package com.algaworks.algafood.jpa.formapagamento;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaFormaPagamento {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        FormaPagamentoRepository formasPagamento = applicationContext.getBean(FormaPagamentoRepository.class);

        List<FormaPagamento> todasCozinhas = formasPagamento.listar();
        todasCozinhas.forEach(e -> System.out.println(e.getDescricao()));
    }
}
