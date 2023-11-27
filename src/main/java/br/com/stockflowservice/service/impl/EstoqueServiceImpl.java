package br.com.stockflowservice.service.impl;

import br.com.stockflowservice.domain.Estoque;
import br.com.stockflowservice.domain.Produto;
import br.com.stockflowservice.domain.dto.EstoqueDTO;
import br.com.stockflowservice.exception.StockFlowException;
import br.com.stockflowservice.repository.EstoqueRepository;
import br.com.stockflowservice.service.EstoqueService;
import br.com.stockflowservice.service.ProdutoService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.helpers.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class EstoqueServiceImpl implements EstoqueService {

    @Autowired
    private EstoqueRepository EstoqueRepository;

    @Autowired
    @Lazy
    private ProdutoService produtoService;

    @Override
    public Estoque criarEstoque(EstoqueDTO estoqueDTO) {
        Estoque estoque = new Estoque(estoqueDTO);
        Produto produto = produtoService.buscarUmProduto(estoqueDTO.produtoDTO().id());
        estoque.setProduto(produto);
        return EstoqueRepository.save(estoque);
    }

    @Override
    public Estoque criarEstoque (EstoqueDTO estoqueDTO, Produto produto) {
        Estoque estoque = new Estoque(estoqueDTO);
        estoque.setProduto(produto);
        return EstoqueRepository.save(estoque);
    }

    @Override
    public List<Estoque> buscarTodasEstoque() {
        return EstoqueRepository.findAll();
    }

    @Override
    public Estoque buscarUmEstoque(Long id) {
        return EstoqueRepository.findById(id).orElseThrow(() -> new StockFlowException("Estoque não encontrada!"));
    }

    @Override
    public Estoque alterarEstoque(EstoqueDTO estoqueDTO) {

        Estoque estoque = this.buscarUmEstoque(estoqueDTO.id());
        estoque.setQuantidade(estoqueDTO.quantidade());
        estoque.setSituacao(estoque.getSituacao());
        estoque.setPrecoCompra(estoqueDTO.precoCompra());
        estoque.setPrecoVenda(estoqueDTO.precoVenda());

        Produto produto = produtoService.buscarUmProduto(estoqueDTO.produtoDTO().id());

        log.info("PRODUTO: " + produto.getNome()+ " " + produto.getId());

        if (Objects.nonNull(produto)) {
            estoque.setProduto(produto);
        }

        return EstoqueRepository.save(estoque);
    }

    @Override
    public void deletarEstoque(Long id) {
        Estoque estoque = this.buscarUmEstoque(id);
        EstoqueRepository.delete(estoque);
    }

    @Override
    public void deletarEstoque(EstoqueDTO estoqueDTO) {
        Estoque estoqueEncontrado = this.buscarUmEstoque(estoqueDTO.id());
        EstoqueRepository.delete(estoqueEncontrado);
    }
}
