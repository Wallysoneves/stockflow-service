package br.com.stockflowservice.service.impl;

import br.com.stockflowservice.domain.ItemPedido;
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
    public ItemPedido criarItemPedido(ItemPedido itemPedido) {
        return ItemPedidoRepository.save(itemPedido);
    }

    @Override
    public List<ItemPedido> buscarTodasItemPedido() {
        return ItemPedidoRepository.findAll();
    }

    @Override
    public ItemPedido buscarUmaItemPedido(ItemPedidoId id) throws Exception {
        return ItemPedidoRepository.findById(id).orElseThrow(() -> new Exception("ItemPedido não encontrada!"));
    }

    @Override
    public ItemPedido alterarItemPedido(ItemPedido itemPedido) throws Exception {

        if (ItemPedidoRepository.exists(Example.of(itemPedido))) {
            return ItemPedidoRepository.save(itemPedido);
        } else {
            throw new Exception("ItemPedido não encontrada!");
        }
    }

    @Override
    public void deletarItemPedido(ItemPedidoId id) throws Exception {
        ItemPedido itemPedido = this.buscarUmaItemPedido(id);
        ItemPedidoRepository.delete(itemPedido);
    }

    @Override
    public void deletarItemPedido(ItemPedido itemPedido) throws Exception {
        ItemPedido itemPedidoEncontrado = this.buscarUmaItemPedido(itemPedido.getId());
        ItemPedidoRepository.delete(itemPedidoEncontrado);
    }
}
