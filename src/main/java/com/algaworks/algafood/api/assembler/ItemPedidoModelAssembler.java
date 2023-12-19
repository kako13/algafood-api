package com.algaworks.algafood.api.assembler;

import com.algaworks.algafood.api.model.ItemPedidoModel;
import com.algaworks.algafood.domain.model.ItemPedido;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Getter
@Setter
public class ItemPedidoModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public ItemPedidoModel toModel(ItemPedido itemPedido) {
        return modelMapper.map(itemPedido, ItemPedidoModel.class);
    }

    public List<ItemPedidoModel> toCollectionModel(List<ItemPedido> itensPedido) {
        return itensPedido.stream()
                .map(this::toModel)
                .toList();
    }
}
