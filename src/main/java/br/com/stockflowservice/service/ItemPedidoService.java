package br.com.stockflowservice.service;

import br.com.stockflowservice.domain.ItemPedido;
import br.com.stockflowservice.domain.dto.ItemPedidoDTO;
import br.com.stockflowservice.domain.dto.ItemPedidoIdDTO;
import br.com.stockflowservice.domain.id.ItemPedidoId;

import java.util.List;

public interface ItemPedidoService {

    ItemPedido criarItemPedido(ItemPedidoDTO ItemPedido);

    List<ItemPedido> buscarTodasItemPedido();

    ItemPedido buscarUmItemPedido(ItemPedidoIdDTO id) throws Exception;

    ItemPedido alterarItemPedido(ItemPedidoDTO ItemPedido) throws Exception;

    void deletarItemPedido(ItemPedidoIdDTO id) throws Exception;

    void deletarItemPedido(ItemPedidoDTO ItemPedido) throws Exception;
}
