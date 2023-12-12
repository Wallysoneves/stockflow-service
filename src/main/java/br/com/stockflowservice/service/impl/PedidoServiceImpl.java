package br.com.stockflowservice.service.impl;

import br.com.stockflowservice.domain.Estoque;
import br.com.stockflowservice.domain.Pedido;
import br.com.stockflowservice.domain.dto.EstoqueDTO;
import br.com.stockflowservice.domain.dto.PedidoDTO;
import br.com.stockflowservice.exception.StockFlowException;
import br.com.stockflowservice.repository.PedidoRepository;
import br.com.stockflowservice.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository PedidoRepository;

    @Override
    public Pedido criarPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido(pedidoDTO);
        pedido.setNumeroPedido(PedidoRepository.buscarUltimoNumeroPedido().orElseThrow(() -> new StockFlowException("Erro ao gerar Pedido, procure o suporte", HttpStatus.BAD_REQUEST)));
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
        Pedido pedido = this.buscarUmPedido(pedidoDTO.getId());
            return PedidoRepository.save(pedido);
    }

    @Override
    public void deletarPedido(Long id) {
        Pedido pedido = this.buscarUmPedido(id);
        PedidoRepository.delete(pedido);
    }

    @Override
    public void deletarPedido(PedidoDTO pedido) {
        Pedido pedidoEncontrado = this.buscarUmPedido(pedido.getId());
        PedidoRepository.delete(pedidoEncontrado);
    }
}
