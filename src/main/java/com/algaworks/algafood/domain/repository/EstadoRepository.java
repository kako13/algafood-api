package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Estado;

import java.util.List;


public interface EstadoRepository {

    //Orientado a persistência
    List<Estado> listar();
    Estado buscar(Long id);
    Estado salvar(Estado estado);
    void remover(Long id);

    //Orientado a Coleção
//    List<Estado> todas();
//    Estado porId(Long id);
//    Estado adicionar(Estado estado);
//    void remover(Estado estado);
}
