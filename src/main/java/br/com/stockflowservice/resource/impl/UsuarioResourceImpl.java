package br.com.stockflowservice.resource.impl;

import br.com.stockflowservice.domain.Usuario;
import br.com.stockflowservice.resource.UsuarioResource;
import br.com.stockflowservice.service.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    public Usuario criarUsuario(@Valid @RequestBody Usuario usuario) {
        return usuarioService.criarUsuario(usuario);
    }

    @Override
    @GetMapping(value = "/todos",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public List<Usuario> buscarTodasUsuario() {
        return usuarioService.buscarTodasUsuario();
    }

    @Override
    @GetMapping(value = "/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Usuario buscarUmUsuario(@PathVariable("id") Long id) throws Exception {
        return usuarioService.buscarUmUsuario(id);
    }

    @Override
    @PutMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Usuario alterarUsuario(@Valid @RequestBody Usuario usuario) throws Exception {
        return usuarioService.alterarUsuario(usuario);
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
    public void deletarUsuario(@Valid @RequestBody Usuario Usuario) throws Exception {
        usuarioService.deletarUsuario(Usuario);
    }
}
