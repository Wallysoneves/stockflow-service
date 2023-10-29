package br.com.stockflowservice.service;

import br.com.stockflowservice.domain.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario criarUsuario(Usuario Usuario);

    List<Usuario> buscarTodasUsuario();

    Usuario buscarUmaUsuario(Long id) throws Exception;

    Usuario alterarUsuario(Usuario Usuario) throws Exception;

    void deletarUsuario(Long id) throws Exception;

    void deletarUsuario(Usuario Usuario) throws Exception;
}
