package br.com.stockflowservice.resource;

import br.com.stockflowservice.domain.Estoque;
import br.com.stockflowservice.domain.dto.EstoqueDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EstoqueResource {

    ResponseEntity<Estoque> criarEstoque(EstoqueDTO Estoque);

    ResponseEntity<List<Estoque>> buscarTodasEstoque();

    ResponseEntity<Estoque> buscarUmEstoque(Long id);

    ResponseEntity<Estoque> buscarEstoqueCodigoBarra(Long codigoBarra);

    ResponseEntity<Estoque> alterarEstoque(EstoqueDTO Estoque);

    void deletarEstoque(Long id);

    void deletarEstoque(EstoqueDTO Estoque);
}
