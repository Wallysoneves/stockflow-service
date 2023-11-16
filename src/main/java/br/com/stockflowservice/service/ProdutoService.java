package br.com.stockflowservice.service;

import br.com.stockflowservice.domain.Produto;
import br.com.stockflowservice.domain.dto.ProdutoDTO;

import java.util.List;

public interface ProdutoService {

    Produto criarProduto(ProdutoDTO Produto) throws Exception;

    List<Produto> buscarTodasProduto();

    Produto buscarUmProduto(Long id) throws Exception;

    Produto alterarProduto(ProdutoDTO Produto) throws Exception;

    void deletarProduto(Long id) throws Exception;

    void deletarProduto(ProdutoDTO Produto) throws Exception;
}
