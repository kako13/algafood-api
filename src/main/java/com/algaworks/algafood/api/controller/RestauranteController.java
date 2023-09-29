package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.Groups;
import com.algaworks.algafood.domain.exception.CozinhaNaoEncontradaException;
import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.domain.service.CadastroRestauranteService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CadastroRestauranteService cadastroService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Restaurante> listar() {
        return restauranteRepository.findAll();
    }

    @GetMapping("/{restauranteId}")
    public Restaurante buscar(@PathVariable Long restauranteId) {
        return cadastroService.buscarOuFalhar(restauranteId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurante adicionar(@RequestBody @Validated(Groups.CadastroRestaurante.class) Restaurante restaurante) {
        try {
            return cadastroService.salvar(restaurante);
        } catch (CozinhaNaoEncontradaException e) {
            throw new NegocioException(e.getMessage(), e.getCause());
        }
    }

    @PutMapping("/{restauranteId}")
    public Restaurante atualizar(@PathVariable Long restauranteId, @RequestBody Restaurante restaurante) {
            Restaurante restauranteAtual = cadastroService.buscarOuFalhar(restauranteId);
            BeanUtils.copyProperties(restaurante, restauranteAtual, "id", "formasPagamento", "endereco", "dataCadastro");
        try {
            return cadastroService.salvar(restauranteAtual);
        } catch (CozinhaNaoEncontradaException e) {
            throw new NegocioException(e.getMessage(), e.getCause());
        }
    }

    @PatchMapping("/{restauranteId}")
    public Restaurante atualizarParcial(@PathVariable Long restauranteId, @RequestBody Map<String, Object> campos, HttpServletRequest request) {
        Restaurante restauranteAtual = cadastroService.buscarOuFalhar(restauranteId);
        merge(campos, restauranteAtual, request);
        return atualizar(restauranteId, restauranteAtual);
    }

    private static void merge(Map<String, Object> dadosOrigem, Restaurante restauranteDestino, HttpServletRequest request) {

        ServletServerHttpRequest servletServerHttpRequest = new ServletServerHttpRequest(request);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

            Restaurante restauranteOrigem = objectMapper.convertValue(dadosOrigem, Restaurante.class);
            dadosOrigem.forEach((nomePropriedade, valorPropriedade) ->
                    Optional.ofNullable(ReflectionUtils.findField(Restaurante.class, nomePropriedade))
                    .ifPresent(e -> {
                        e.setAccessible(true);
                        Object novoValor = ReflectionUtils.getField(e, restauranteOrigem);
                        ReflectionUtils.setField(e, restauranteDestino, novoValor);
                    }));
        } catch (IllegalArgumentException e) {
            Throwable rootCause = ExceptionUtils.getRootCause(e);
            throw new HttpMessageNotReadableException(e.getMessage(), rootCause, servletServerHttpRequest);
        }
    }
}
