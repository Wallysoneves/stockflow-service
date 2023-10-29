package br.com.stockflowservice.resource.impl;

import br.com.stockflowservice.domain.Pedido;
import br.com.stockflowservice.resource.PedidoResource;
import br.com.stockflowservice.service.PedidoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    public Pedido criarPedido(@Valid @RequestBody Pedido pedido) {
        return pedidoService.criarPedido(pedido);
    }

    @Override
    @GetMapping(value = "/todos",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public List<Pedido> buscarTodasPedido() {
        return pedidoService.buscarTodasPedido();
    }

    @Override
    @GetMapping(value = "/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Pedido buscarUmPedido(@PathVariable("id") Long id) throws Exception {
        return pedidoService.buscarUmPedido(id);
    }

    @Override
    @PutMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Pedido alterarPedido(@Valid @RequestBody Pedido pedido) throws Exception {
        return pedidoService.alterarPedido(pedido);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void deletarPedido(@PathVariable("id") Long id) throws Exception {
        pedidoService.deletarPedido(id);
    }

    @Override
    @DeleteMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public void deletarPedido(@Valid @RequestBody Pedido Pedido) throws Exception {
        pedidoService.deletarPedido(Pedido);
    }
}
