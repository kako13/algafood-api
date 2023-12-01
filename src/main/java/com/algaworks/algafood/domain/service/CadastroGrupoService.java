package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.GrupoNaoEncontradoException;
import com.algaworks.algafood.domain.model.Grupo;
import com.algaworks.algafood.domain.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroGrupoService {

    private static final String MSG_GRUPO_EM_USO = "Grupo de código %d não pode ser removido, pois está em uso";
    @Autowired
    private GrupoRepository grupoRepository;

    @Transactional
    public Grupo salvar(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    public Grupo buscarOuFalhar(Long id) {
        return grupoRepository.findById(id)
                .orElseThrow(() -> new GrupoNaoEncontradoException(id));
    }

    @Transactional
    public void excluir(Long grupoId) {
        try {
            grupoRepository.deleteById(grupoId);
            grupoRepository.flush();

        } catch (EmptyResultDataAccessException e) {
            throw new GrupoNaoEncontradoException(grupoId);

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_GRUPO_EM_USO, grupoId));
        }
    }
}
