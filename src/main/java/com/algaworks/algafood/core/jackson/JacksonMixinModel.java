package com.algaworks.algafood.core.jackson;

import com.algaworks.algafood.api.model.mixin.CidadeMixin;
import com.algaworks.algafood.api.model.mixin.CozinhaMixin;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Cozinha;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.stereotype.Component;

@Component
public class JacksonMixinModel extends SimpleModule {

    public JacksonMixinModel() {
        super.setMixInAnnotation(Cozinha.class, CozinhaMixin.class);
        super.setMixInAnnotation(Cidade.class, CidadeMixin.class);
    }
}
