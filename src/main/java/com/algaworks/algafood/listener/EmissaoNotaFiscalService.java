package com.algaworks.algafood.listener;

import com.algaworks.algafood.di.service.ClienteAtivadoEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmissaoNotaFiscalService {
    @EventListener
    public void emissaoNotaFiscalListener(ClienteAtivadoEvent event) {
        System.out.println("Emitindo nota fiscal para o cliente: " + event.getCliente().getNome());
    }
}
