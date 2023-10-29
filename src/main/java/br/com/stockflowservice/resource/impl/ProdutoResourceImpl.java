package br.com.stockflowservice.resource.impl;

import br.com.stockflowservice.domain.Produto;
import br.com.stockflowservice.resource.ProdutoResource;
import br.com.stockflowservice.service.ProdutoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    public Produto criarProduto(@Valid @RequestBody Produto produto) {
        return produtoService.criarProduto(produto);
    }

    @Override
    @GetMapping(value = "/todos",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public List<Produto> buscarTodasProduto() {
        return produtoService.buscarTodasProduto();
    }

    @Override
    @GetMapping(value = "/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Produto buscarUmProduto(@PathVariable("id") Long id) throws Exception {
        return produtoService.buscarUmProduto(id);
    }

    @Override
    @PutMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Produto alterarProduto(@Valid @RequestBody Produto produto) throws Exception {
        return produtoService.alterarProduto(produto);
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
    public void deletarProduto(@Valid @RequestBody Produto produto) throws Exception {
        produtoService.deletarProduto(produto);
    }
}
