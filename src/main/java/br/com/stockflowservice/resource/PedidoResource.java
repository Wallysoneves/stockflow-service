package br.com.stockflowservice.resource;

import br.com.stockflowservice.domain.Pedido;
import br.com.stockflowservice.domain.dto.PedidoDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PedidoResource {

    ResponseEntity<Pedido> criarPedido(PedidoDTO Pedido);

    ResponseEntity<List<Pedido>> buscarTodasPedido();

    ResponseEntity<Pedido> buscarUmPedido(Long id);

    ResponseEntity<Pedido> alterarPedido(PedidoDTO Pedido);

    void deletarPedido(Long id);

    void deletarPedido(PedidoDTO Pedido);
}
