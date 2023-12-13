package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.exception.PedidoNaoEncontradoException;
import com.algaworks.algafood.domain.model.*;
import com.algaworks.algafood.domain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmissaoPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private CadastroUsuarioService cadastroUsuario;

    @Autowired
    private CadastroRestauranteService cadastroRestaurante;

    @Autowired
    private CadastroFormaPagamentoService cadastroFormaPagamento;

    @Autowired
    private CadastroProdutoService cadastroProduto;

    @Autowired
    private CadastroCidadeService cadastroCidade;

    public Pedido buscarOuFalhar(String codigoPedido) {
        return pedidoRepository.findByCodigo(codigoPedido)
                .orElseThrow(() -> new PedidoNaoEncontradoException(codigoPedido));
    }

    @Transactional
    public Pedido emitir(Pedido pedido) {
        validarCliente(pedido);
        validarRestaurante(pedido);
        validarFormaDePagamento(pedido);
        validarItensProdutos(pedido);
        validarCidade(pedido);
        pedido.setTaxaFrete(pedido.getRestaurante().getTaxaFrete());
        pedido.calcularValorTotal();
        return pedidoRepository.save(pedido);
    }

    private void validarCidade(Pedido pedido) {
        Cidade cidade = cadastroCidade.buscarOuFalhar(pedido.getEndereco().getCidade().getId());
        pedido.getEndereco().setCidade(cidade);
    }

    private void validarItensProdutos(Pedido pedido) {
        Long restauranteId = pedido.getRestaurante().getId();
        pedido.getItens()
                .forEach(e -> {
                    Produto produto = cadastroProduto.buscarOuFalhar(restauranteId, e.getProduto().getId());
                    e.setProduto(produto);
                    e.setPedido(pedido);
                    e.definirValorUnitario();
                    e.calcularPrecoTotal();
                });
    }

    private void validarCliente(Pedido pedido) {
        Usuario usuario = cadastroUsuario.buscarOuFalhar(pedido.getCliente().getId());
        pedido.setCliente(usuario);
    }

    private void validarRestaurante(Pedido pedido) {
        Restaurante restaurante = cadastroRestaurante.buscarOuFalhar(pedido.getRestaurante().getId());
        if (!restaurante.getAtivo())
            throw new NegocioException(String.format(
                    "O restaurante '%s' não está ativo",restaurante.getNome()));
        if (!restaurante.getAberto())
            throw new NegocioException(String.format(
                    "O restaurante '%s' se encontra fechado no momento \uD83D\uDE2D",restaurante.getNome()));
        pedido.setRestaurante(restaurante);
    }

    private void validarFormaDePagamento(Pedido pedido) {
        FormaPagamento formaPagamento = cadastroFormaPagamento.buscarOuFalhar(pedido.getFormaPagamento().getId());
        Restaurante restaurante = pedido.getRestaurante();
        if (restaurante.naoAceitaFormaPagamento(formaPagamento))
            throw new NegocioException(String.format("Forma de pagamento '%s' não é aceita por esse restaurante.",
                    formaPagamento.getDescricao()));
        pedido.setFormaPagamento(formaPagamento);
    }
}
