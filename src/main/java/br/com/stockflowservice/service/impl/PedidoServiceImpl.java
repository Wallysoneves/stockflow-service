package br.com.stockflowservice.service.impl;

import br.com.stockflowservice.domain.Pedido;
import br.com.stockflowservice.domain.dto.PedidoDTO;
import br.com.stockflowservice.exception.StockFlowException;
import br.com.stockflowservice.repository.PedidoRepository;
import br.com.stockflowservice.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository PedidoRepository;

    @Override
    public Pedido criarPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        return PedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> buscarTodasPedido() {
        return PedidoRepository.findAll();
    }

    @Override
    public Pedido buscarUmPedido(Long id) {
        return PedidoRepository.findById(id).orElseThrow(() -> new StockFlowException("Pedido não encontrada!"));
    }

    @Override
    public Pedido alterarPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = this.buscarUmPedido(pedidoDTO.id());
            return PedidoRepository.save(pedido);
    }

    @Override
    public void deletarPedido(Long id) {
        Pedido pedido = this.buscarUmPedido(id);
        PedidoRepository.delete(pedido);
    }

    @Override
    public void deletarPedido(PedidoDTO pedido) {
        Pedido pedidoEncontrado = this.buscarUmPedido(pedido.id());
        PedidoRepository.delete(pedidoEncontrado);
    }
}
