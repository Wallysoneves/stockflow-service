package br.com.stockflowservice.resource.impl;

import br.com.stockflowservice.domain.Categoria;
import br.com.stockflowservice.resource.CategoriaResource;
import br.com.stockflowservice.service.CategoriaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@Tags({
        @Tag(name = "categoria", description = "documentação ao resource categoria")
})
public class CategoriaResourceImpl implements CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @Override
    @PostMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Categoria criarCategoria(@Valid @RequestBody Categoria categoria) {
        return categoriaService.criarCategoria(categoria);
    }

    @Override
    @GetMapping(value = "/todos",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public List<Categoria> buscarTodasCategoria() {
        return categoriaService.buscarTodasCategoria();
    }

    @Override
    @GetMapping(value = "/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Categoria buscarUmaCategoria(@PathVariable("id") Long id) throws Exception {
        return categoriaService.buscarUmaCategoria(id);
    }

    @Override
    @PutMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Categoria alterarCategoria(@Valid @RequestBody Categoria categoria) throws Exception {
        return categoriaService.alterarCategoria(categoria);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void deletarCategoria(@PathVariable("id") Long id) throws Exception {
        categoriaService.deletarCategoria(id);
    }

    @Override
    @DeleteMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public void deletarCategoria(@Valid @RequestBody Categoria categoria) throws Exception {
        categoriaService.deletarCategoria(categoria);
    }
}
