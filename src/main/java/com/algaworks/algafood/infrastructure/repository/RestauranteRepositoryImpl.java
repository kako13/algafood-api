package com.algaworks.algafood.infrastructure.repository;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {
    @PersistenceContext
    public EntityManager manager;

    @Override
    public List<Restaurante> listar() {
        return manager.createQuery("from Restaurante", Restaurante.class).getResultList();
    }

    @Override
    @Transactional
    public Restaurante salvar(Restaurante restaurante) {
        return manager.merge(restaurante);
    }

    @Override
    public Restaurante buscar(Long id) {
        return manager.find(Restaurante.class, id);
    }

    @Override
    @Transactional
    public void remover(Restaurante restaurante) {
        restaurante = buscar(restaurante.getId());
        manager.remove(restaurante);
    }
}
