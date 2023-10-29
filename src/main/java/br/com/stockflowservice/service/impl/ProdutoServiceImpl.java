package br.com.stockflowservice.service.impl;

import br.com.stockflowservice.domain.Produto;
import br.com.stockflowservice.repository.ProdutoRepository;
import br.com.stockflowservice.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public List<Produto> buscarTodasProduto() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto buscarUmaProduto(Long id) throws Exception {
        return produtoRepository.findById(id).orElseThrow(() -> new Exception("Produto não encontrada!"));
    }

    @Override
    public Produto alterarProduto(Produto produto) throws Exception {

        if (produtoRepository.exists(Example.of(produto))) {
            return produtoRepository.save(produto);
        } else {
            throw new Exception("Produto não encontrada!");
        }
    }

    @Override
    public void deletarProduto(Long id) throws Exception {
        Produto produto = this.buscarUmaProduto(id);
        produtoRepository.delete(produto);
    }

    @Override
    public void deletarProduto(Produto produto) throws Exception {
        Produto produtoEncontrado = this.buscarUmaProduto(produto.getId());
        produtoRepository.delete(produtoEncontrado);
    }
}
