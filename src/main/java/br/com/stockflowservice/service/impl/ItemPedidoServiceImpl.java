package br.com.stockflowservice.service.impl;

import br.com.stockflowservice.domain.Estoque;
import br.com.stockflowservice.domain.Item;
import br.com.stockflowservice.domain.dto.ItemPedidoDTO;
import br.com.stockflowservice.domain.dto.ItemPedidoIdDTO;
import br.com.stockflowservice.domain.id.ItemId;
import br.com.stockflowservice.exception.StockFlowException;
import br.com.stockflowservice.repository.EstoqueRepository;
import br.com.stockflowservice.repository.ItemPedidoRepository;
import br.com.stockflowservice.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemPedidoServiceImpl implements ItemPedidoService {

    @Autowired
    private ItemPedidoRepository ItemPedidoRepository;

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Override
    public Item criarItemPedido(ItemPedidoDTO itemPedidoDTO) {
        Item item = new Item(itemPedidoDTO);

        Estoque estoque = estoqueRepository.findByProduto(item.getId().getProduto()).orElseThrow(() -> new StockFlowException("Esse produto não possui estoque!!!", HttpStatus.NOT_FOUND));

        if (estoque.getQuantidade() < item.getQuantidade()) {
            throw new StockFlowException("Quantidade selecionada há cima do disponivel em estoque!", HttpStatus.BAD_REQUEST);
        } else {
            estoque.setQuantidade(estoque.getQuantidade() - item.getQuantidade());
            estoqueRepository.save(estoque);
        }

        return ItemPedidoRepository.save(item);
    }

    @Override
    @Transactional
    public List<Item> criarItemPedidos(List<ItemPedidoDTO> ItensPedidos) {
        List<Item> itens = new ArrayList<>();
        for (ItemPedidoDTO itemDTO: ItensPedidos) {
            itens.add(criarItemPedido(itemDTO));
        }
        return itens;
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
