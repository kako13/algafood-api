package com.algaworks.algafood.infrastructure.repository;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepositoryQueries;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurante> conultar(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
        var jpql = " from Restaurante " +
                " where " +
                " nome like :nome " +
                " and " +
                "taxaFrete between :taxaInicial and :taxaFinal ";

        return manager.createQuery(jpql, Restaurante.class)
                        .setParameter("nome", "%"+nome+"%")
                        .setParameter("taxaInicial", taxaFreteInicial)
                        .setParameter("taxaFinal", taxaFreteFinal)
                        .getResultList();
    }
}
