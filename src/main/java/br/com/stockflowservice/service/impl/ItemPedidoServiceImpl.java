package br.com.stockflowservice.service.impl;

import br.com.stockflowservice.domain.Item;
import br.com.stockflowservice.domain.dto.ItemPedidoDTO;
import br.com.stockflowservice.domain.dto.ItemPedidoIdDTO;
import br.com.stockflowservice.domain.id.ItemId;
import br.com.stockflowservice.exception.StockFlowException;
import br.com.stockflowservice.repository.ItemPedidoRepository;
import br.com.stockflowservice.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoServiceImpl implements ItemPedidoService {

    @Autowired
    private ItemPedidoRepository ItemPedidoRepository;

    @Override
    public Item criarItemPedido(ItemPedidoDTO itemPedidoDTO) {
        Item item = new Item();
        return ItemPedidoRepository.save(item);
    }

    @Override
    public List<Item> buscarTodasItemPedido() {
        return ItemPedidoRepository.findAll();
    }

    @Override
    public Item buscarUmItemPedido(ItemPedidoIdDTO id) {
        ItemId itemId = new ItemId();
        return ItemPedidoRepository.findById(itemId).orElseThrow(() -> new StockFlowException("ItemPedido não encontrada!"));
    }

    @Override
    public Item alterarItemPedido(ItemPedidoDTO itemPedidoDTO) {
        Item item = this.buscarUmItemPedido(itemPedidoDTO.getId());
        return ItemPedidoRepository.save(item);

    }

    @Override
    public void deletarItemPedido(ItemPedidoIdDTO id) {
        Item item = this.buscarUmItemPedido(id);
        ItemPedidoRepository.delete(item);
    }

    @Override
    public void deletarItemPedido(ItemPedidoDTO itemPedidoDTO) {

        Item itemEncontrado = this.buscarUmItemPedido(itemPedidoDTO.getId());
        ItemPedidoRepository.delete(itemEncontrado);
    }
}
