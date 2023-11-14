package br.com.stockflowservice.resource.impl;

import br.com.stockflowservice.domain.Usuario;
import br.com.stockflowservice.domain.dto.UsuarioDTO;
import br.com.stockflowservice.resource.UsuarioResource;
import br.com.stockflowservice.service.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@Tags({
        @Tag(name = "usuario", description = "documentação ao resource usuario")
})
public class UsuarioResourceImpl implements UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    @PostMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<Usuario> criarUsuario(@Valid @RequestBody UsuarioDTO usuario) {
        return ResponseEntity.ok(usuarioService.criarUsuario(usuario));
    }

    @Override
    @GetMapping(value = "/todos",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<List<Usuario>> buscarTodasUsuario() {
        return ResponseEntity.ok(usuarioService.buscarTodasUsuario());
    }

    @Override
    @GetMapping(value = "/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<Usuario> buscarUmUsuario(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(usuarioService.buscarUmUsuario(id));
    }

    @Override
    @PutMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<Usuario> alterarUsuario(@Valid @RequestBody UsuarioDTO usuario) throws Exception {
        return ResponseEntity.ok(usuarioService.alterarUsuario(usuario));
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void deletarUsuario(@PathVariable("id") Long id) throws Exception {
        usuarioService.deletarUsuario(id);
    }

    @Override
    @DeleteMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public void deletarUsuario(@Valid @RequestBody UsuarioDTO usuario) throws Exception {
        usuarioService.deletarUsuario(usuario);
    }
}
