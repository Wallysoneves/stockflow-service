package br.com.stockflowservice.resource;

import br.com.stockflowservice.domain.ItemPedido;
import br.com.stockflowservice.domain.dto.ItemPedidoDTO;
import br.com.stockflowservice.domain.dto.ItemPedidoIdDTO;
import br.com.stockflowservice.domain.id.ItemPedidoId;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemPedidoResource {

    ResponseEntity<ItemPedido> criarItemPedido(ItemPedidoDTO ItemPedido);

    ResponseEntity<List<ItemPedido>> buscarTodasItemPedido();

    ResponseEntity<ItemPedido> buscarUmItemPedido(ItemPedidoIdDTO id);

    ResponseEntity<ItemPedido> alterarItemPedido(ItemPedidoDTO ItemPedido);

    void deletarItemPedido(ItemPedidoIdDTO id);

    void deletarItemPedido(ItemPedidoDTO ItemPedido);
}
