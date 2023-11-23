package br.com.stockflowservice.service;

import br.com.stockflowservice.domain.Usuario;
import br.com.stockflowservice.domain.dto.UsuarioDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsuarioService {

    Usuario criarUsuario(UsuarioDTO Usuario);

    List<Usuario> buscarTodasUsuario();

    Usuario buscarUmUsuario(Long id);

    Usuario buscarUmUsuario(String login, String senha);

    Usuario alterarUsuario(UsuarioDTO Usuario);

    void deletarUsuario(Long id);

    void deletarUsuario(UsuarioDTO Usuario);
}
