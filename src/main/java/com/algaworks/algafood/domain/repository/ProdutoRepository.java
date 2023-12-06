package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

//    @Query("select produto from Produto produto where produto.restaurante.id = :restaurante and id = :produto")
    @Query("select produto from Produto produto where produto.restaurante.id = :restaurante and produto.id = :produto")
    Optional<Produto> findById(@Param("restaurante") Long restaurantId, @Param("produto") Long produtoId);
}
