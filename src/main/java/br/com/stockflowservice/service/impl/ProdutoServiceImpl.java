package br.com.stockflowservice.service.impl;

import br.com.stockflowservice.domain.Categoria;
import br.com.stockflowservice.domain.Produto;
import br.com.stockflowservice.domain.dto.ProdutoDTO;
import br.com.stockflowservice.exception.StockFlowException;
import br.com.stockflowservice.repository.ProdutoRepository;
import br.com.stockflowservice.service.CategoriaService;
import br.com.stockflowservice.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaService categoriaService;

    @Override
    public Produto criarProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto(produtoDTO);
        Categoria categoria = categoriaService.buscarUmaCategoria(produtoDTO.categoriaDTO().id());
        produto.setCategoria(categoria);
        return produtoRepository.save(produto);
    }

    @Override
    public List<Produto> buscarTodasProduto() {
        return produtoRepository.findAll();
    }

    @Override
    public List<Produto> buscarCampoPesquisa (String texto) {
        return produtoRepository.buscarCampoPesquisa(texto).orElseThrow(() -> new StockFlowException("Produto não encontrado!", HttpStatus.BAD_REQUEST));
    }

    @Override
    public Produto buscarUmProduto(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new StockFlowException("Produto não encontrada!"));
    }

    @Override
    public Produto alterarProduto(ProdutoDTO produtoDTO) {
        Produto produto = buscarUmProduto(produtoDTO.id());
        return produtoRepository.save(produto);

    }

    @Override
    public void deletarProduto(Long id) {
        Produto produto = this.buscarUmProduto(id);
        produtoRepository.delete(produto);
    }

    @Override
    public void deletarProduto(ProdutoDTO produto) {
        Produto produtoEncontrado = this.buscarUmProduto(produto.id());
        produtoRepository.delete(produtoEncontrado);
    }
}
