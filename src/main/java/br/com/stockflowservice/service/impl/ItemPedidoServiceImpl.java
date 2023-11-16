package br.com.stockflowservice.service.impl;

import br.com.stockflowservice.domain.ItemPedido;
import br.com.stockflowservice.domain.dto.ItemPedidoDTO;
import br.com.stockflowservice.domain.dto.ItemPedidoIdDTO;
import br.com.stockflowservice.domain.id.ItemPedidoId;
import br.com.stockflowservice.exception.StockFlowException;
import br.com.stockflowservice.repository.ItemPedidoRepository;
import br.com.stockflowservice.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoServiceImpl implements ItemPedidoService {

    @Autowired
    private ItemPedidoRepository ItemPedidoRepository;

    @Override
    public ItemPedido criarItemPedido(ItemPedidoDTO itemPedidoDTO) {
        ItemPedido itemPedido = ItemPedido.convert(itemPedidoDTO);
        return ItemPedidoRepository.save(itemPedido);
    }

    @Override
    public List<ItemPedido> buscarTodasItemPedido() {
        return ItemPedidoRepository.findAll();
    }

    @Override
    public ItemPedido buscarUmItemPedido(ItemPedidoIdDTO id) {
        ItemPedidoId itemPedidoId = ItemPedidoId.convert(id);
        return ItemPedidoRepository.findById(itemPedidoId).orElseThrow(() -> new StockFlowException("ItemPedido não encontrada!"));
    }

    @Override
    public ItemPedido alterarItemPedido(ItemPedidoDTO itemPedidoDTO) {
        ItemPedido itemPedido = this.buscarUmItemPedido(itemPedidoDTO.id());
        return ItemPedidoRepository.save(itemPedido);

    }

    @Override
    public void deletarItemPedido(ItemPedidoIdDTO id) {
        ItemPedido itemPedido = this.buscarUmItemPedido(id);
        ItemPedidoRepository.delete(itemPedido);
    }

    @Override
    public void deletarItemPedido(ItemPedidoDTO itemPedidoDTO) {

        ItemPedido itemPedidoEncontrado = this.buscarUmItemPedido(itemPedidoDTO.id());
        ItemPedidoRepository.delete(itemPedidoEncontrado);
    }
}
