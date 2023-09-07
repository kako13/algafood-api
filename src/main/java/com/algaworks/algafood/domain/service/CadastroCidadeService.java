package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastroCidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public Cidade salvar(Cidade cidade) {
        Long id = cidade.getEstado().getId();
        Optional<Estado> estado = estadoRepository.findById(id);
        if (estado.isEmpty())
            throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de Estado com o código '%d'", id));
        cidade.setEstado(estado.get());
        return cidadeRepository.save(cidade);
    }

    public void excluir(Long id) {
        Optional<Cidade> cidade = cidadeRepository.findById(id);
        if (cidade.isEmpty())
            throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de Estado com o código '%d'", id));
        cidadeRepository.deleteById(id);

    }
}
