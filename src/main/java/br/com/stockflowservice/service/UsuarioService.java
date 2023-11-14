package br.com.stockflowservice.service;

import br.com.stockflowservice.domain.Usuario;
import br.com.stockflowservice.domain.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {

    Usuario criarUsuario(UsuarioDTO Usuario);

    List<Usuario> buscarTodasUsuario();

    Usuario buscarUmUsuario(Long id) throws Exception;

    Usuario alterarUsuario(UsuarioDTO Usuario) throws Exception;

    void deletarUsuario(Long id) throws Exception;

    void deletarUsuario(UsuarioDTO Usuario) throws Exception;
}
