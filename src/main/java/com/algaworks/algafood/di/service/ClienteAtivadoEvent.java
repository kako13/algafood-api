package com.algaworks.algafood.di.service;

import com.algaworks.algafood.di.modelo.Cliente;

public class ClienteAtivadoEvent {

    private final Cliente cliente;

    public ClienteAtivadoEvent(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
