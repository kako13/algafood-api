package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.FormaPagamento;

import java.util.List;


public interface FormaPagamentoRepository {

    //Orientado a persistência
    List<FormaPagamento> listar();
    FormaPagamento buscar(Long id);
    FormaPagamento salvar(FormaPagamento formaPagamento);
    void remover(FormaPagamento formaPagamento);

    //Orientado a Coleção
//    List<FormaPagamento> todas();
//    FormaPagamento porId(Long id);
//    FormaPagamento adicionar(FormaPagamento formaPagamento);
//    void remover(FormaPagamento formaPagamento);
}
