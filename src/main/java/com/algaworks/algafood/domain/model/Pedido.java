package com.algaworks.algafood.domain.model;

import com.algaworks.algafood.domain.exception.NegocioException;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Pedido {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private BigDecimal subtotal;
    private BigDecimal taxaFrete;
    private BigDecimal valorTotal;
    @CreationTimestamp
    private OffsetDateTime dataCriacao;
    private OffsetDateTime dataConfirmacao;
    private OffsetDateTime dataCancelamento;
    private OffsetDateTime dataEntrega;
    @Enumerated(EnumType.STRING)
    private StatusPedido status = StatusPedido.CRIADO;

    @Embedded
    private Endereco endereco;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itens = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private FormaPagamento formaPagamento;

    @ManyToOne
    @JoinColumn(nullable = false, name = "usuario_cliente_id")
    private Usuario cliente;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Restaurante restaurante;

    public void calcularValorTotal(){
        this.subtotal = getItens().stream()
                .peek(ItemPedido::calcularPrecoTotal)
                .map(ItemPedido::getPrecoTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        this.valorTotal = subtotal.add(this.taxaFrete);
    }

    public void confirmar() {
        this.setStatus(StatusPedido.CONFIRMADO);
        this.setDataConfirmacao(OffsetDateTime.now());
    }

    public void cancelar() {
        this.setStatus(StatusPedido.CANCELADO);
        this.setDataCancelamento(OffsetDateTime.now());
    }

    public void entregar() {
        this.setStatus(StatusPedido.ENTREGUE);
        this.setDataEntrega(OffsetDateTime.now());
    }

    private void setStatus(StatusPedido novoStatus) {
        if (getStatus().naoPodeAlterarPara(novoStatus)) {
            throw new NegocioException(
                    String.format("Status do pedido %s não pode ser alterado de %s para %s.",
                            this.getCodigo(),
                            this.getStatus().getDescricao(),
                            novoStatus.getDescricao()));
        } else {
            this.status = novoStatus;
        }
    }

    @PrePersist
    private void gerarCodigo() {
        setCodigo(UUID.randomUUID().toString());
    }
}
