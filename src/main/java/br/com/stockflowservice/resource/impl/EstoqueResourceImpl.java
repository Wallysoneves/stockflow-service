package br.com.stockflowservice.resource.impl;

import br.com.stockflowservice.domain.Estoque;
import br.com.stockflowservice.domain.dto.EstoqueDTO;
import br.com.stockflowservice.resource.EstoqueResource;
import br.com.stockflowservice.service.EstoqueService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
@Tags({
        @Tag(name = "estoque", description = "documentação ao resource estoque")
})
public class EstoqueResourceImpl implements EstoqueResource {

    @Autowired
    private EstoqueService estoqueService;

    @Override
    @PostMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<Estoque> criarEstoque(@Valid @RequestBody EstoqueDTO estoque) {
        return ResponseEntity.ok(estoqueService.criarEstoque(estoque));
    }

    @Override
    @GetMapping(value = "/todos",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<List<Estoque>> buscarTodasEstoque() {
        return ResponseEntity.ok(estoqueService.buscarTodasEstoque());
    }

    @Override
    @GetMapping(value = "/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<Estoque> buscarUmEstoque(@PathVariable("id") Long id) {
        return ResponseEntity.ok(estoqueService.buscarUmEstoque(id));
    }

    @Override
    @GetMapping(value = "/codigo-barra",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<Estoque> buscarEstoqueCodigoBarra(@RequestParam("codigoBarra") Long codigoBarra) {
        return ResponseEntity.ok(estoqueService.buscarEstoqueCodigoBarra(codigoBarra));
    }

    @Override
    @PutMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<Estoque> alterarEstoque(@Valid @RequestBody EstoqueDTO estoque) {
        return ResponseEntity.ok(estoqueService.alterarEstoque(estoque));
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void deletarEstoque(@PathVariable("id") Long id) {
        estoqueService.deletarEstoque(id);
    }

    @Override
    @DeleteMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public void deletarEstoque(@Valid @RequestBody EstoqueDTO estoque) {
        estoqueService.deletarEstoque(estoque);
    }
}
