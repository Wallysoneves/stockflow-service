package br.com.stockflowservice.service;

import br.com.stockflowservice.domain.Pedido;
import br.com.stockflowservice.domain.dto.PedidoDTO;

import java.util.List;

public interface PedidoService {

    Pedido criarPedido(PedidoDTO Pedido);

    List<Pedido> buscarTodasPedido();

    Pedido buscarUmPedido(Long id) throws Exception;

    Pedido alterarPedido(PedidoDTO Pedido) throws Exception;

    void deletarPedido(Long id) throws Exception;

    void deletarPedido(PedidoDTO Pedido) throws Exception;
}
