package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Restaurante;

import java.util.List;


public interface RestauranteRepository {

    //Orientado a persistência
    List<Restaurante> listar();
    Restaurante buscar(Long id);
    Restaurante salvar(Restaurante restaurante);
    void remover(Restaurante restaurante);

    //Orientado a Coleção
//    List<Restaurante> todos();
//    Restaurante porId(Long id);
//    Restaurante adicionar(Restaurante restaurante);
//    void remover(Restaurante restaurante);
}
