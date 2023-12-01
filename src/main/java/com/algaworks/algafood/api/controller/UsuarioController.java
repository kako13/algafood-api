package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.assembler.UsuarioInputDisassembler;
import com.algaworks.algafood.api.assembler.UsuarioModelAssembler;
import com.algaworks.algafood.api.model.UsuarioModel;
import com.algaworks.algafood.api.model.input.SenhaInput;
import com.algaworks.algafood.api.model.input.UsuarioInput;
import com.algaworks.algafood.domain.model.Usuario;
import com.algaworks.algafood.domain.repository.UsuarioRepository;
import com.algaworks.algafood.domain.service.CadastroUsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioModelAssembler usuarioModelAssembler;

    @Autowired
    private UsuarioInputDisassembler usuarioInputDisassembler;

    @Autowired
    private CadastroUsuarioService cadastroUsuario;


    @GetMapping
    public List<UsuarioModel> listar() {
        return usuarioModelAssembler.toColletcionModel(usuarioRepository.findAll());
    }

    @GetMapping("/{idUsuario}")
    public UsuarioModel buscar(@PathVariable Long idUsuario) {
        return usuarioModelAssembler.toModel(cadastroUsuario.buscarOuFalhar(idUsuario));
    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public UsuarioModel adicionar(@RequestBody @Valid UsuarioComSenhaInput usuarioComSenhaInput) {
//        Usuario usuario = cadastroUsuario.salvar(usuarioInputDisassembler.toDomainObject(usuarioComSenhaInput));
//        return usuarioModelAssembler.toModel(usuario);
//
//    }

    @PutMapping("/{idUsuario}")
    public UsuarioModel atualizar(@PathVariable Long idUsuario, @RequestBody @Valid UsuarioInput usuarioInput) {
        Usuario usuarioAtual = cadastroUsuario.buscarOuFalhar(idUsuario);
        usuarioInputDisassembler.copyToDomainObject(usuarioInput, usuarioAtual);
        cadastroUsuario.salvar();
        return usuarioModelAssembler.toModel(usuarioAtual);
    }

    @PutMapping("/{idUsuario}/senha")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterarSenha(@PathVariable Long idUsuario, @RequestBody @Valid SenhaInput senhaInput) {
        cadastroUsuario.alterarSenha(idUsuario, senhaInput.getSenhaAtual(), senhaInput.getNovaSenha());
    }
}