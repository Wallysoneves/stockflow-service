package br.com.stockflowservice.resource.impl;

import br.com.stockflowservice.domain.Produto;
import br.com.stockflowservice.domain.dto.ProdutoDTO;
import br.com.stockflowservice.resource.ProdutoResource;
import br.com.stockflowservice.service.ProdutoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@Tags({
        @Tag(name = "produto", description = "documentação ao resource produto")
})
public class ProdutoResourceImpl implements ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @Override
    @PostMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<Produto> criarProduto(@Valid @RequestBody ProdutoDTO produto) {
        return ResponseEntity.ok(produtoService.criarProduto(produto));
    }

    @Override
    @GetMapping(value = "/todos",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<List<Produto>> buscarTodasProduto() {
        return ResponseEntity.ok(produtoService.buscarTodasProduto());
    }

    @Override
    @GetMapping(value = "/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<Produto> buscarUmProduto(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(produtoService.buscarUmProduto(id));
    }

    @Override
    @PutMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<Produto> alterarProduto(@Valid @RequestBody ProdutoDTO produto) throws Exception {
        return ResponseEntity.ok(produtoService.alterarProduto(produto));
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void deletarProduto(@PathVariable("id") Long id) throws Exception {
        produtoService.deletarProduto(id);
    }

    @Override
    @DeleteMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public void deletarProduto(@Valid @RequestBody ProdutoDTO produto) throws Exception {
        produtoService.deletarProduto(produto);
    }
}
