package br.com.stockflowservice.resource;

import br.com.stockflowservice.domain.Pedido;

import java.util.List;

public interface PedidoResource {

    Pedido criarPedido(Pedido Pedido);

    List<Pedido> buscarTodasPedido();

    Pedido buscarUmPedido(Long id) throws Exception;

    Pedido alterarPedido(Pedido Pedido) throws Exception;

    void deletarPedido(Long id) throws Exception;

    void deletarPedido(Pedido Pedido) throws Exception;
}
