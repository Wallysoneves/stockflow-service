package br.com.stockflowservice.resource;

import br.com.stockflowservice.domain.ItemPedido;
import br.com.stockflowservice.domain.id.ItemPedidoId;

import java.util.List;

public interface ItemPedidoResource {

    ItemPedido criarItemPedido(ItemPedido ItemPedido);

    List<ItemPedido> buscarTodasItemPedido();

    ItemPedido buscarUmItemPedido(ItemPedidoId id) throws Exception;

    ItemPedido alterarItemPedido(ItemPedido ItemPedido) throws Exception;

    void deletarItemPedido(ItemPedidoId id) throws Exception;

    void deletarItemPedido(ItemPedido ItemPedido) throws Exception;
}
