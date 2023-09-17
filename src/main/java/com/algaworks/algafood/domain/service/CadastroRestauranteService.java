package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroRestauranteService {

    public static final String MSG_COZINHA_NAO_ENCONTRADA = "Não existe cadastro de cozinha com o código %d";
    @Autowired
    private RestauranteRepository restauranteRepository;
    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Restaurante salvar(Restaurante restaurante) {
        validaCozinha(restaurante);
        return restauranteRepository.save(restaurante);
    }

    private void validaCozinha(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();
        cozinhaRepository.findById(cozinhaId)
                .map(e -> {
                    restaurante.setCozinha(e);
                    return null;
                })
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format(MSG_COZINHA_NAO_ENCONTRADA, cozinhaId)));
    }

    public Restaurante buscarOuFalhar(Long id) {
        return restauranteRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(String.format(MSG_COZINHA_NAO_ENCONTRADA, id)));
    }
}
