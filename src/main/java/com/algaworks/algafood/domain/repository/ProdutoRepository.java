package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Produto;
import com.algaworks.algafood.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

//    @Query(value = "select p from produto p WHERE p.restaurante_id = :restaurantId and p.id = :produtoId", nativeQuery = true)
    @Query("select produto from Produto produto where produto.restaurante.id = :restaurante and produto.id = :produto")
    Optional<Produto> findById(@Param("restaurante") Long restaurantId, @Param("produto") Long produtoId);

    List<Produto> findByRestaurante(Restaurante restaurante);

    @Query("from Produto p where p.ativo = true and p.restaurante = :restaurante")
    List<Produto> findAtivosByRestaurante(Restaurante restaurante);
}
