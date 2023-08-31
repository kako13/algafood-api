package com.algaworks.algafood.jpa;

import com.algaworks.algafood.domain.model.Cozinha;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CadastroCozinha {

    @PersistenceContext
    public EntityManager manager;

    public List<Cozinha> listar() {
        return manager.createQuery("from Cozinha", Cozinha.class).getResultList();
    }

    @Transactional
    public Cozinha adicionar(Cozinha cozinha) {
        return manager.merge(cozinha);
    }

    public Cozinha buscar(Long id) {
        return manager.find(Cozinha.class, id);
    }
}
