package br.com.stockflowservice.resource.impl;

import br.com.stockflowservice.domain.ItemPedido;
import br.com.stockflowservice.domain.dto.ItemPedidoDTO;
import br.com.stockflowservice.domain.dto.ItemPedidoIdDTO;
import br.com.stockflowservice.domain.id.ItemPedidoId;
import br.com.stockflowservice.resource.ItemPedidoResource;
import br.com.stockflowservice.service.ItemPedidoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itemPedido")
@Tags({
        @Tag(name = "itemPedido", description = "documentação ao resource itemPedido")
})
public class ItemPedidoResourceImpl implements ItemPedidoResource {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @Override
    @PostMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<ItemPedido> criarItemPedido(@Valid @RequestBody ItemPedidoDTO itemPedido) {
        return ResponseEntity.ok(itemPedidoService.criarItemPedido(itemPedido));
    }

    @Override
    @GetMapping(value = "/todos",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<List<ItemPedido>> buscarTodasItemPedido() {
        return ResponseEntity.ok(itemPedidoService.buscarTodasItemPedido());
    }

    @Override
    @GetMapping(value = "/id",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<ItemPedido> buscarUmItemPedido(@Valid @RequestBody ItemPedidoIdDTO id) {
        return ResponseEntity.ok(itemPedidoService.buscarUmItemPedido(id));
    }

    @Override
    @PutMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<ItemPedido> alterarItemPedido(@Valid @RequestBody ItemPedidoDTO itemPedido) {
        return ResponseEntity.ok(itemPedidoService.alterarItemPedido(itemPedido));
    }

    @Override
    @DeleteMapping(value = "/id")
    public void deletarItemPedido(@Valid @RequestBody ItemPedidoIdDTO id) {
        itemPedidoService.deletarItemPedido(id);
    }

    @Override
    @DeleteMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public void deletarItemPedido(@Valid @RequestBody ItemPedidoDTO itemPedido) {
        itemPedidoService.deletarItemPedido(itemPedido);
    }
}
