package br.com.stockflowservice.resource.impl;

import br.com.stockflowservice.domain.Pedido;
import br.com.stockflowservice.domain.dto.PedidoDTO;
import br.com.stockflowservice.resource.PedidoResource;
import br.com.stockflowservice.service.PedidoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@Tags({
        @Tag(name = "pedido", description = "documentação ao resource pedido")
})
public class PedidoResourceImpl implements PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @Override
    @PostMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<Pedido> criarPedido(@Valid @RequestBody PedidoDTO pedido) {
        return ResponseEntity.ok(pedidoService.criarPedido(pedido));
    }

    @Override
    @GetMapping(value = "/todos",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<List<Pedido>> buscarTodasPedido() {
        return ResponseEntity.ok(pedidoService.buscarTodasPedido());
    }

    @Override
    @GetMapping(value = "/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<Pedido> buscarUmPedido(@PathVariable("id") Long id) {
        return ResponseEntity.ok(pedidoService.buscarUmPedido(id));
    }

    @Override
    @PutMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<Pedido> alterarPedido(@Valid @RequestBody PedidoDTO pedido) {
        return ResponseEntity.ok(pedidoService.alterarPedido(pedido));
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void deletarPedido(@PathVariable("id") Long id) {
        pedidoService.deletarPedido(id);
    }

    @Override
    @DeleteMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public void deletarPedido(@Valid @RequestBody PedidoDTO Pedido) {
        pedidoService.deletarPedido(Pedido);
    }
}
