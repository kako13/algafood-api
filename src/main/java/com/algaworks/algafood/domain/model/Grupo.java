package com.algaworks.algafood.domain.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Data
@Entity
public class Grupo {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;

    @JoinTable(name = "grupo_permissao",
        joinColumns = @JoinColumn(name = "grupo_id"),
        inverseJoinColumns = @JoinColumn(name = "permissao_id"))
    @ManyToMany
    private Set<Permissao> permissoes = new HashSet<>();

    public boolean adicionarPermissao(Permissao permissao) {
        return getPermissoes().add(permissao);
    }

    public boolean removerPermissao(Permissao permissao) {
        return getPermissoes().remove(permissao);
    }
}
