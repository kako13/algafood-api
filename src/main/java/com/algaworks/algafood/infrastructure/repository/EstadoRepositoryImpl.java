package com.algaworks.algafood.infrastructure.repository;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EstadoRepositoryImpl implements EstadoRepository {
    @PersistenceContext
    public EntityManager manager;

    @Override
    public List<Estado> listar() {
        return manager.createQuery("from Estado", Estado.class).getResultList();
    }

    @Override
    @Transactional
    public Estado salvar(Estado estado) {
        return manager.merge(estado);
    }

    @Override
    public Estado buscar(Long id) {
        return manager.find(Estado.class, id);
    }

    @Override
    @Transactional
    public void remover(Estado estado) {
        estado = buscar(estado.getId());
        manager.remove(estado);
    }
}
