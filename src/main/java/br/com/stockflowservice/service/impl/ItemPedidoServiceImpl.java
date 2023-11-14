package br.com.stockflowservice.service.impl;

import br.com.stockflowservice.domain.ItemPedido;
import br.com.stockflowservice.domain.dto.ItemPedidoDTO;
import br.com.stockflowservice.domain.dto.ItemPedidoIdDTO;
import br.com.stockflowservice.domain.id.ItemPedidoId;
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
    public ItemPedido buscarUmItemPedido(ItemPedidoIdDTO id) throws Exception {
        ItemPedidoId itemPedidoId = ItemPedidoId.convert(id);
        return ItemPedidoRepository.findById(itemPedidoId).orElseThrow(() -> new Exception("ItemPedido não encontrada!"));
    }

    @Override
    public ItemPedido alterarItemPedido(ItemPedidoDTO itemPedidoDTO) throws Exception {
        ItemPedido itemPedido = ItemPedido.convert(itemPedidoDTO);
        if (ItemPedidoRepository.exists(Example.of(itemPedido))) {
            return ItemPedidoRepository.save(itemPedido);
        } else {
            throw new Exception("ItemPedido não encontrada!");
        }
    }

    @Override
    public void deletarItemPedido(ItemPedidoIdDTO id) throws Exception {
        ItemPedido itemPedido = this.buscarUmItemPedido(id);
        ItemPedidoRepository.delete(itemPedido);
    }

    @Override
    public void deletarItemPedido(ItemPedidoDTO itemPedidoDTO) throws Exception {

        ItemPedido itemPedidoEncontrado = this.buscarUmItemPedido(itemPedidoDTO.id());
        ItemPedidoRepository.delete(itemPedidoEncontrado);
    }
}
