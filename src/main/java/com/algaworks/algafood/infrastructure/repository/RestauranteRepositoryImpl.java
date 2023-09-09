package com.algaworks.algafood.infrastructure.repository;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepositoryQueries;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurante> consultar(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();

        CriteriaQuery<Restaurante> criteria = builder.createQuery(Restaurante.class);
        Root<Restaurante> root = criteria.from(Restaurante.class);// from Restaurante, root é a 'entidade'

        var predicates = new ArrayList<Predicate>();

        if (StringUtils.hasLength(nome)) {
            Predicate nomePredicate = builder.like(root.get("nome"), "%" + nome + "%");// Predicate é a condição, filtro
            predicates.add(nomePredicate);
        }

        if (taxaFreteInicial != null) {
            Predicate taxaInicialPredicate = builder.greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteInicial);
            predicates.add(taxaInicialPredicate);
        }

        if (taxaFreteFinal != null) {
            Predicate taxaFinalPredicate = builder.lessThanOrEqualTo(root.get("taxaFrete"), taxaFreteFinal);
            predicates.add(taxaFinalPredicate);
        }


        criteria.where(predicates.toArray(new Predicate[0])); // AND para cada predicado

        TypedQuery<Restaurante> typedQuery = manager.createQuery(criteria);
        return typedQuery.getResultList();
    }
}
