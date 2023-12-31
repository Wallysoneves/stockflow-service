package br.com.stockflowservice.service.impl;

import br.com.stockflowservice.domain.Estoque;
import br.com.stockflowservice.domain.Produto;
import br.com.stockflowservice.domain.dto.EstoqueDTO;
import br.com.stockflowservice.exception.StockFlowException;
import br.com.stockflowservice.repository.EstoqueRepository;
import br.com.stockflowservice.service.EstoqueService;
import br.com.stockflowservice.service.ProdutoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class EstoqueServiceImpl implements EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    @Lazy
    private ProdutoService produtoService;

    @Override
    public Estoque criarEstoque(EstoqueDTO estoqueDTO) {
        Estoque estoque = new Estoque(estoqueDTO);
        Produto produto = produtoService.buscarUmProduto(estoqueDTO.getProdutoDTO().getId());
        estoque.setProduto(produto);
        return estoqueRepository.save(estoque);
    }

    @Override
    public Estoque criarEstoque (EstoqueDTO estoqueDTO, Produto produto) {
        Estoque estoque = new Estoque(estoqueDTO);
        estoque.setProduto(produto);
        return estoqueRepository.save(estoque);
    }

    @Override
    public List<Estoque> buscarTodasEstoque() {
        return estoqueRepository.findAll();
    }

    @Override
    public Estoque buscarUmEstoque(Long id) {
        return estoqueRepository.findById(id).orElseThrow(() -> new StockFlowException("Estoque não encontrada!"));
    }

    @Override
    public Estoque buscarUmEstoque(Produto produto) {
        return estoqueRepository.findByProduto(produto).orElseThrow(() -> new StockFlowException("Estoque não encontrado, não é possivel continuar", HttpStatus.BAD_REQUEST));
    }

    @Override
    public Estoque buscarEstoqueCodigoBarra(Long codigoBarra) {
        return estoqueRepository.buscarEstoqueCodigoBarra(codigoBarra)
                .orElseThrow(() -> new StockFlowException("Estoque não encontrado, por favor valide o código de barra!", HttpStatus.BAD_REQUEST));
    }

    @Override
    public Estoque alterarEstoque(EstoqueDTO estoqueDTO) {

        Estoque estoque = this.buscarUmEstoque(estoqueDTO.getId());
        estoque.setQuantidade(estoqueDTO.getQuantidade());
        estoque.setSituacao(estoqueDTO.getSituacao());
        estoque.setPrecoCompra(estoqueDTO.getPrecoCompra());
        estoque.setPrecoVenda(estoqueDTO.getPrecoVenda());

        Produto produto = produtoService.buscarUmProduto(estoqueDTO.getProdutoDTO().getId());

        log.info("PRODUTO: " + produto.getNome()+ " " + produto.getId());

        if (Objects.nonNull(produto)) {
            estoque.setProduto(produto);
        }

        return estoqueRepository.save(estoque);
    }

    @Override
    public void deletarEstoque(Long id) {
        Estoque estoque = this.buscarUmEstoque(id);
        estoqueRepository.delete(estoque);
    }

    @Override
    public void deletarEstoque(EstoqueDTO estoqueDTO) {
        Estoque estoqueEncontrado = this.buscarUmEstoque(estoqueDTO.getId());
        estoqueRepository.delete(estoqueEncontrado);
    }
}
