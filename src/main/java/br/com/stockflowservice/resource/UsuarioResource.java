package br.com.stockflowservice.resource;

import br.com.stockflowservice.domain.Usuario;
import br.com.stockflowservice.domain.dto.UsuarioDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsuarioResource {

    ResponseEntity<Usuario> criarUsuario(UsuarioDTO Usuario);

    ResponseEntity<List<Usuario>> buscarTodasUsuario();

    ResponseEntity<Usuario> buscarUmUsuario(Long id) throws Exception;

    ResponseEntity<Usuario> alterarUsuario(UsuarioDTO Usuario) throws Exception;

    void deletarUsuario(Long id) throws Exception;

    void deletarUsuario(UsuarioDTO Usuario) throws Exception;
}
