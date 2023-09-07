package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Cozinha;

import java.util.List;


public interface CozinhaRepository {

    //Orientado a persistência
    List<Cozinha> listar();
    List<Cozinha> consultarPorNome(String nome);
    Cozinha buscar(Long id);
    Cozinha salvar(Cozinha cozinha);
    void remover(Long id);

    //Orientado a Coleção
//    List<Cozinha> todas();
//    Cozinha porId(Long id);
//    Cozinha adicionar(Cozinha cozinha);
//    void remover(Cozinha cozinha);
}
