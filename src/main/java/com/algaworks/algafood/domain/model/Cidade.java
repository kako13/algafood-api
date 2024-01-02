package com.algaworks.algafood.domain.model;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotBlank
    @Column(nullable = false)
    private String nome;

//    @Valid
//    @ConvertGroup(to = Groups.EstadoId.class)
//    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false)
    private Estado estado;
}
