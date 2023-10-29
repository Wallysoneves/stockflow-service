package br.com.stockflowservice.service;

import br.com.stockflowservice.domain.Produto;

import java.util.List;

public interface ProdutoService {

    Produto criarProduto(Produto Produto);

    List<Produto> buscarTodasProduto();

    Produto buscarUmaProduto(Long id) throws Exception;

    Produto alterarProduto(Produto Produto) throws Exception;

    void deletarProduto(Long id) throws Exception;

    void deletarProduto(Produto Produto) throws Exception;
}
