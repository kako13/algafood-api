package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.model.CozinhaXMLWrapper;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/cozinhas")
public class CozinhaController {

    @Autowired
    public CozinhaRepository cozinhaRepository;

    @GetMapping
    public List<Cozinha> listar() {
        return cozinhaRepository.listar();
    }

    @GetMapping("/{id}")
    public Cozinha buscar(@PathVariable Long id) {
        return cozinhaRepository.buscar(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public CozinhaXMLWrapper listarXml() {
        return new CozinhaXMLWrapper(cozinhaRepository.listar());
    }
}
