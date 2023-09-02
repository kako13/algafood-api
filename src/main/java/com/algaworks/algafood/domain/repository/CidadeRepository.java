package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Cidade;

import java.util.List;


public interface CidadeRepository {

    //Orientado a persistência
    List<Cidade> listar();
    Cidade buscar(Long id);
    Cidade salvar(Cidade cidade);
    void remover(Cidade cidade);

    //Orientado a Coleção
//    List<Cidade> todas();
//    Cidade porId(Long id);
//    Cidade adicionar(Cidade cidade);
//    void remover(Cidade cidade);
}
