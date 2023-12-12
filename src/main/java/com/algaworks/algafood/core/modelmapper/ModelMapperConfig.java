package com.algaworks.algafood.core.modelmapper;

import com.algaworks.algafood.api.model.EnderecoModel;
import com.algaworks.algafood.api.model.PedidoModel;
import com.algaworks.algafood.api.model.input.ItemPedidoInput;
import com.algaworks.algafood.domain.model.Endereco;
import com.algaworks.algafood.domain.model.ItemPedido;
import com.algaworks.algafood.domain.model.Pedido;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {

        var modelMapper = new ModelMapper();

//        modelMapper.createTypeMap(Restaurante.class, RestauranteModel.class)
//                .addMapping(Restaurante::getTaxaFrete, RestauranteModel::getPrecoFrete);
//      INPUT
        modelMapper.createTypeMap(ItemPedidoInput.class, ItemPedido.class)
                .addMappings(input -> input.skip(ItemPedido::setId));

//      OUTPUT
        modelMapper.createTypeMap(Pedido.class, PedidoModel.class)
                .addMapping(Pedido::getEndereco, PedidoModel::setEnderecoEntrega);

//
//                .<String>addMapping(
//                        enderecoSrc -> enderecoSrc.getEndereco().getCidade().getEstado().getNome(), //retorna o value
//                        (enderecoModelDest, value) -> enderecoModelDest.getEnderecoEntrega().getCidade().setEstado(value)); // seta o value no destino;

        TypeMap<Endereco, EnderecoModel> enderecoToEnderecoModelTypeMap = modelMapper.createTypeMap(
                Endereco.class, EnderecoModel.class);

        enderecoToEnderecoModelTypeMap.<String>addMapping(
                enderecoSrc -> enderecoSrc.getCidade().getEstado().getNome(), //retorna o value
                (enderecoModelDest, value) -> enderecoModelDest.getCidade().setEstado(value)); // seta o value no destino

        return modelMapper;
    }
}
