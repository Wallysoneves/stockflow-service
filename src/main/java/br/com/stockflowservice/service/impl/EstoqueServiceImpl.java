package br.com.stockflowservice.service.impl;

import br.com.stockflowservice.domain.Estoque;
import br.com.stockflowservice.domain.Produto;
import br.com.stockflowservice.domain.dto.EstoqueDTO;
import br.com.stockflowservice.repository.EstoqueRepository;
import br.com.stockflowservice.service.EstoqueService;
import br.com.stockflowservice.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueServiceImpl implements EstoqueService {

    @Autowired
    private EstoqueRepository EstoqueRepository;

    @Autowired
    private ProdutoService produtoService;

    @Override
    public Estoque criarEstoque(EstoqueDTO estoqueDTO) throws Exception {
        Estoque estoque = new Estoque(estoqueDTO);
        Produto produto = produtoService.buscarUmProduto(estoqueDTO.produtoDTO().id());
        estoque.setProduto(produto);
        return EstoqueRepository.save(estoque);
    }

    @Override
    public List<Estoque> buscarTodasEstoque() {
        return EstoqueRepository.findAll();
    }

    @Override
    public Estoque buscarUmEstoque(Long id) throws Exception {
        return EstoqueRepository.findById(id).orElseThrow(() -> new Exception("Estoque não encontrada!"));
    }

    @Override
    public Estoque alterarEstoque(EstoqueDTO estoqueDTO) throws Exception {
        Estoque estoque = this.buscarUmEstoque(estoqueDTO.id());
        estoque.setQuantidade(estoqueDTO.quantidade());
        estoque.setSituacao(estoque.getSituacao());
        estoque.setPrecoCompra(estoqueDTO.precoCompra());
        estoque.setPrecoVenda(estoqueDTO.precoVenda());
        return EstoqueRepository.save(estoque);
    }

    @Override
    public void deletarEstoque(Long id) throws Exception {
        Estoque estoque = this.buscarUmEstoque(id);
        EstoqueRepository.delete(estoque);
    }

    @Override
    public void deletarEstoque(EstoqueDTO estoqueDTO) throws Exception {
        Estoque estoqueEncontrado = this.buscarUmEstoque(estoqueDTO.id());
        EstoqueRepository.delete(estoqueEncontrado);
    }
}
