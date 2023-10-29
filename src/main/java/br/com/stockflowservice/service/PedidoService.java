package br.com.stockflowservice.service;

import br.com.stockflowservice.domain.Pedido;

import java.util.List;

public interface PedidoService {

    Pedido criarPedido(Pedido Pedido);

    List<Pedido> buscarTodasPedido();

    Pedido buscarUmaPedido(Long id) throws Exception;

    Pedido alterarPedido(Pedido Pedido) throws Exception;

    void deletarPedidoPorId(Long id) throws Exception;

    void deletarPedido(Pedido Pedido) throws Exception;
}
