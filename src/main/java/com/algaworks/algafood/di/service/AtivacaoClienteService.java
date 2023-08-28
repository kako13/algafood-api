package com.algaworks.algafood.di.service;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificacao.Notificador;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

	private final Notificador notificador;

	public AtivacaoClienteService(Notificador notificador) {
		this.notificador = notificador;
		System.out.println(this.getClass().getSimpleName() + " " + notificador);
	}

	public void ativar(Cliente cliente) {
		cliente.ativar();
		this.notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
	}
}
