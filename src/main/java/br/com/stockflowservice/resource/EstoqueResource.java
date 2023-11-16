package br.com.stockflowservice.resource;

import br.com.stockflowservice.domain.Estoque;
import br.com.stockflowservice.domain.dto.EstoqueDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EstoqueResource {

    ResponseEntity<Estoque> criarEstoque(EstoqueDTO Estoque) throws Exception;

    ResponseEntity<List<Estoque>> buscarTodasEstoque();

    ResponseEntity<Estoque> buscarUmEstoque(Long id) throws Exception;

    ResponseEntity<Estoque> alterarEstoque(EstoqueDTO Estoque) throws Exception;

    void deletarEstoque(Long id) throws Exception;

    void deletarEstoque(EstoqueDTO Estoque) throws Exception;
}
