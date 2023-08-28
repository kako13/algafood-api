package com.algaworks.algafood.di.notificacao;


import com.algaworks.algafood.di.modelo.Cliente;
import org.springframework.stereotype.Component;

public class NotificadorEmail implements Notificador {

	private boolean caixaAlta;
	private final String hostServidor;


	public NotificadorEmail(String hostServidor) {
		this.hostServidor = hostServidor;
		System.out.println("Notificador email" + this);
	}

	@Override
	public void notificar(Cliente cliente, String mensagem) {

		if (caixaAlta)
			mensagem = mensagem.toUpperCase();

		System.out.printf("Notificando %s através do e-mail %s usando SMTP %s: %s\n",
				cliente.getNome(), cliente.getEmail(), this.hostServidor, mensagem);
	}

	public void setCaixaAlta(boolean caixaAlta) {
		this.caixaAlta = caixaAlta;
	}
}
