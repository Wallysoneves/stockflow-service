package br.com.stockflowservice.service;

import br.com.stockflowservice.domain.Produto;
import br.com.stockflowservice.domain.dto.ProdutoDTO;

import java.util.List;

public interface ProdutoService {

    Produto criarProduto(ProdutoDTO Produto);

    List<Produto> buscarTodasProduto();

    List<Produto> buscarCampoPesquisa(String texto);

    Produto buscarUmProduto(Long id);

    Produto alterarProduto(ProdutoDTO Produto);

    void deletarProduto(Long id);

    void deletarProduto(ProdutoDTO Produto);
}
