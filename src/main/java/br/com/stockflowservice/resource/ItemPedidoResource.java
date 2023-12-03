package br.com.stockflowservice.resource;

import br.com.stockflowservice.domain.Item;
import br.com.stockflowservice.domain.dto.ItemPedidoDTO;
import br.com.stockflowservice.domain.dto.ItemPedidoIdDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemPedidoResource {

    ResponseEntity<Item> criarItemPedido(ItemPedidoDTO ItemPedido);

    ResponseEntity<List<Item>> buscarTodasItemPedido();

    ResponseEntity<Item> buscarUmItemPedido(ItemPedidoIdDTO id);

    ResponseEntity<Item> alterarItemPedido(ItemPedidoDTO ItemPedido);

    void deletarItemPedido(ItemPedidoIdDTO id);

    void deletarItemPedido(ItemPedidoDTO ItemPedido);
}
