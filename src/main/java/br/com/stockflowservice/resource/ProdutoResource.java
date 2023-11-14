package br.com.stockflowservice.resource;

import br.com.stockflowservice.domain.Produto;
import br.com.stockflowservice.domain.dto.ProdutoDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProdutoResource {

    ResponseEntity<Produto> criarProduto(ProdutoDTO Produto);

    ResponseEntity<List<Produto>> buscarTodasProduto();

    ResponseEntity<Produto> buscarUmProduto(Long id) throws Exception;

    ResponseEntity<Produto> alterarProduto(ProdutoDTO Produto) throws Exception;

    void deletarProduto(Long id) throws Exception;

    void deletarProduto(ProdutoDTO Produto) throws Exception;
}
