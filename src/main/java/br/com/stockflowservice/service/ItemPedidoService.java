package br.com.stockflowservice.service;

import br.com.stockflowservice.domain.Item;
import br.com.stockflowservice.domain.dto.ItemPedidoDTO;
import br.com.stockflowservice.domain.dto.ItemPedidoIdDTO;

import java.util.List;

public interface ItemPedidoService {

    Item criarItemPedido(ItemPedidoDTO ItemPedido);

    List<Item> buscarTodasItemPedido();

    Item buscarUmItemPedido(ItemPedidoIdDTO id);

    Item alterarItemPedido(ItemPedidoDTO ItemPedido);

    void deletarItemPedido(ItemPedidoIdDTO id);

    void deletarItemPedido(ItemPedidoDTO ItemPedido);
}
