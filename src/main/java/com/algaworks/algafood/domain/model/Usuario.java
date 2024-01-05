package com.algaworks.algafood.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Usuario {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String senha;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime(6)")
    private OffsetDateTime dataCadastro;

    @JoinTable(name = "usuario_grupo",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "grupo_id"))
    @ManyToMany
    private Set<Grupo> grupos = new HashSet<>();

    public boolean senhaCoincideCom(String senhaAtual) {
        return getSenha().equals(senhaAtual);
    }

    public boolean senhaNaoCoincideCom(String senhaAtual) {
        return !senhaCoincideCom(senhaAtual);
    }

    public boolean adicionarGrupo(Grupo grupo) {
        return getGrupos().add(grupo);
    }

    public boolean removerGrupo(Grupo grupo) {
        return getGrupos().remove(grupo);
    }
}
