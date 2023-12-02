package com.algaworks.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface CustomJpaRepository<T, D> extends JpaRepository<T, D> {
    Optional<T> buscarPrimeiro();

    void detached (T entity);
}
