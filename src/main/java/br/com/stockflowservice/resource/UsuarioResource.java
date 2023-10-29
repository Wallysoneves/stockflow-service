package br.com.stockflowservice.resource;

import br.com.stockflowservice.domain.Usuario;

import java.util.List;

public interface UsuarioResource {

    Usuario criarUsuario(Usuario Usuario);

    List<Usuario> buscarTodasUsuario();

    Usuario buscarUmUsuario(Long id) throws Exception;

    Usuario alterarUsuario(Usuario Usuario) throws Exception;

    void deletarUsuario(Long id) throws Exception;

    void deletarUsuario(Usuario Usuario) throws Exception;
}
