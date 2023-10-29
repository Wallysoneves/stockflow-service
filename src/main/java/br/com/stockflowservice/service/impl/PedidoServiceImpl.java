package br.com.stockflowservice.service.impl;

import br.com.stockflowservice.domain.Pedido;
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
    public Pedido criarPedido(Pedido pedido) {
        return PedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> buscarTodasPedido() {
        return PedidoRepository.findAll();
    }

    @Override
    public Pedido buscarUmaPedido(Long id) throws Exception {
        return PedidoRepository.findById(id).orElseThrow(() -> new Exception("Pedido não encontrada!"));
    }

    @Override
    public Pedido alterarPedido(Pedido pedido) throws Exception {

        if (PedidoRepository.exists(Example.of(pedido))) {
            return PedidoRepository.save(pedido);
        } else {
            throw new Exception("Pedido não encontrada!");
        }
    }

    @Override
    public void deletarPedido(Long id) throws Exception {
        Pedido pedido = this.buscarUmaPedido(id);
        PedidoRepository.delete(pedido);
    }

    @Override
    public void deletarPedido(Pedido pedido) throws Exception {
        Pedido pedidoEncontrado = this.buscarUmaPedido(pedido.getId());
        PedidoRepository.delete(pedidoEncontrado);
    }
}
