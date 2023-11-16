package br.com.stockflowservice.service;

import br.com.stockflowservice.domain.Pedido;
import br.com.stockflowservice.domain.dto.PedidoDTO;

import java.util.List;

public interface PedidoService {

    Pedido criarPedido(PedidoDTO Pedido);

    List<Pedido> buscarTodasPedido();

    Pedido buscarUmPedido(Long id);

    Pedido alterarPedido(PedidoDTO Pedido);

    void deletarPedido(Long id);

    void deletarPedido(PedidoDTO Pedido);
}
