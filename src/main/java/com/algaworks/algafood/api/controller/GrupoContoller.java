package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.assembler.GrupoInputDisassembler;
import com.algaworks.algafood.api.assembler.GrupoModelAssembler;
import com.algaworks.algafood.api.model.GrupoModel;
import com.algaworks.algafood.api.model.input.GrupoInput;
import com.algaworks.algafood.domain.model.Grupo;
import com.algaworks.algafood.domain.repository.GrupoRepository;
import com.algaworks.algafood.domain.service.CadastroGrupoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos")
public class GrupoContoller {

    @Autowired
    private GrupoRepository grupoRepository;
    @Autowired
    private CadastroGrupoService cadastroGrupo;

    @Autowired
    private GrupoInputDisassembler grupoInputDisassembler;

    @Autowired
    private GrupoModelAssembler grupoModelAssembler;

    @GetMapping
    public List<GrupoModel> listar() {
        return grupoModelAssembler.toCollectionModel(grupoRepository.findAll());
    }

    @GetMapping("/{grupoId}")
    public GrupoModel buscar(@PathVariable Long grupoId) {
        return grupoModelAssembler.toModel(cadastroGrupo.buscarOuFalhar(grupoId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GrupoModel adicionar(@RequestBody @Valid GrupoInput grupoInput) {
        Grupo grupo = cadastroGrupo.salvar(grupoInputDisassembler.toDomainObject(grupoInput));
        return grupoModelAssembler.toModel(grupo);
    }

    @PutMapping("/{grupoId}")
    public GrupoModel atualizar(@PathVariable Long grupoId, @RequestBody @Valid GrupoInput grupoInput) {
        Grupo grupoAtual = cadastroGrupo.buscarOuFalhar(grupoId);
        grupoInputDisassembler.copyToDomainObject(grupoInput, grupoAtual);
        return grupoModelAssembler.toModel(cadastroGrupo.salvar(grupoAtual));
    }

    @DeleteMapping("/{grupoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long grupoId) {
        cadastroGrupo.excluir(grupoId);
    }
}
