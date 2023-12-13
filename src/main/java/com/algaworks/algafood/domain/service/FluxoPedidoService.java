package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.model.Pedido;
import com.algaworks.algafood.domain.model.StatusPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Service
public class FluxoPedidoService {

    public static final String MSG_STATUS_NAO_PODE_SER_ALTERADO = "Status do pedido %s não pode ser alterado de %s para %s.";
    @Autowired
    private EmissaoPedidoService emissaoPedido;

    // para entregue tem que estar confirmado
    // para cancelado ele deve estar criado

    @Transactional
    public void confirmar(Long pedidoId) {
        Pedido pedido = emissaoPedido.buscarOuFalhar(pedidoId);

        if (!pedido.getStatus().equals(StatusPedido.CRIADO))
            throw new NegocioException(
                    String.format(MSG_STATUS_NAO_PODE_SER_ALTERADO,
                            pedido.getId(),
                            pedido.getStatus().getDescricao(),
                            StatusPedido.CONFIRMADO.getDescricao()));

        pedido.setStatus(StatusPedido.CONFIRMADO);
        pedido.setDataConfirmacao(OffsetDateTime.now());
    }

    @Transactional
    public void cancelar(Long pedidoId) {
        Pedido pedido = emissaoPedido.buscarOuFalhar(pedidoId);

        if (!pedido.getStatus().equals(StatusPedido.CRIADO))
            throw new NegocioException(
                    String.format(MSG_STATUS_NAO_PODE_SER_ALTERADO,
                            pedido.getId(),
                            pedido.getStatus().getDescricao(),
                            StatusPedido.CANCELADO.getDescricao()));

        pedido.setStatus(StatusPedido.CANCELADO);
        pedido.setDataCancelamento(OffsetDateTime.now());
    }

    @Transactional
    public void entregar(Long pedidoId) {
        Pedido pedido = emissaoPedido.buscarOuFalhar(pedidoId);

        if (!pedido.getStatus().equals(StatusPedido.CONFIRMADO))
            throw new NegocioException(
                    String.format(MSG_STATUS_NAO_PODE_SER_ALTERADO,
                            pedido.getId(),
                            pedido.getStatus().getDescricao(),
                            StatusPedido.ENTREGUE.getDescricao()));

        pedido.setStatus(StatusPedido.ENTREGUE);
        pedido.setDataEntrega(OffsetDateTime.now());
    }
}
