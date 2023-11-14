package br.com.stockflowservice.resource;

import br.com.stockflowservice.domain.Estoque;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EstoqueResource {

    ResponseEntity<Estoque> criarEstoque(Estoque Estoque);

    ResponseEntity<List<Estoque>> buscarTodasEstoque();

    ResponseEntity<Estoque> buscarUmEstoque(Long id) throws Exception;

    ResponseEntity<Estoque> alterarEstoque(Estoque Estoque) throws Exception;

    void deletarEstoque(Long id) throws Exception;

    void deletarEstoque(Estoque Estoque) throws Exception;
}
