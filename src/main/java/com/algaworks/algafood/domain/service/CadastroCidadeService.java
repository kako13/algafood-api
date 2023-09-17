package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastroCidadeService {

    public static final String MSG_ESTADO_NAO_ENCONTRADO = "Não existe um cadastro de Estado com o código '%d'";
    public static final String MSG_CIDADE_EM_USO = "Cidade de codigo '%d' não pode ser removida, pois está em uso";
    public static final String MSG_CIDADE_NAO_ENCONTRADA = "Não existe um cadastro de Cidade com o código '%d'";
    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public Cidade salvar(Cidade cidade) {
        Long id = cidade.getEstado().getId();
        return estadoRepository.findById(id)
                .map(e -> {
                    cidade.setEstado(e);
                    return cidadeRepository.save(cidade);
                })
                .orElseThrow(() -> new EntidadeNaoEncontradaException(String.format(MSG_ESTADO_NAO_ENCONTRADO, id)));
    }

    public void excluir(Long id) {
        try {
            Optional.of(cidadeRepository.findById(id)
                            .orElseThrow(() -> new EmptyResultDataAccessException(1)))
                    .ifPresent(n -> cidadeRepository.delete(n));
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(String.format(MSG_CIDADE_NAO_ENCONTRADA, id));
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format(MSG_CIDADE_EM_USO, id));
        }
    }

    public Cidade buscarOuFalhar(Long id) {
        return cidadeRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(String.format(MSG_CIDADE_NAO_ENCONTRADA, id)));
    }
}
