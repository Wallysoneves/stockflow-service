package br.com.stockflowservice.resource;

import br.com.stockflowservice.domain.Pedido;
import br.com.stockflowservice.domain.dto.PedidoDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PedidoResource {

    ResponseEntity<Pedido> criarPedido(PedidoDTO Pedido);

    ResponseEntity<List<Pedido>> buscarTodasPedido();

    ResponseEntity<Pedido> buscarUmPedido(Long id) throws Exception;

    ResponseEntity<Pedido> alterarPedido(PedidoDTO Pedido) throws Exception;

    void deletarPedido(Long id) throws Exception;

    void deletarPedido(PedidoDTO Pedido) throws Exception;
}
