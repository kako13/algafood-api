package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Cozinha;

import java.util.List;

public interface CozinhaRepository {

    //Orientado a persistência
    List<Cozinha> listar();
    Cozinha buscar(Long id);
    Cozinha salvar(Cozinha cozinha);
    void remover(Cozinha cozinha);

    //Orientado a Coleção
//    List<Cozinha> todas();
//    Cozinha porId(Long id);
//    Cozinha adicionar(Cozinha cozinha);
//    void remover(Cozinha cozinha);
}
