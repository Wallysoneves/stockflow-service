package br.com.stockflowservice.resource;

import br.com.stockflowservice.domain.Produto;

import java.util.List;

public interface ProdutoResource {

    Produto criarProduto(Produto Produto);

    List<Produto> buscarTodasProduto();

    Produto buscarUmProduto(Long id) throws Exception;

    Produto alterarProduto(Produto Produto) throws Exception;

    void deletarProduto(Long id) throws Exception;

    void deletarProduto(Produto Produto) throws Exception;
}
