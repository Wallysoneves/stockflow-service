package br.com.stockflowservice.resource;

import br.com.stockflowservice.domain.Produto;
import br.com.stockflowservice.domain.dto.ProdutoDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProdutoResource {

    ResponseEntity<Produto> criarProduto(ProdutoDTO Produto);

    ResponseEntity<List<Produto>> buscarTodasProduto();

    ResponseEntity<List<Produto>> buscarCampoPesquisa(String texto);

    ResponseEntity<Produto> buscarUmProduto(Long id);

    ResponseEntity<Produto> alterarProduto(ProdutoDTO Produto);

    void deletarProduto(Long id);

    void deletarProduto(ProdutoDTO Produto);
}
