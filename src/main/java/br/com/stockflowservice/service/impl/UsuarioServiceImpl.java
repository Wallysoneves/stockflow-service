package br.com.stockflowservice.service.impl;

import br.com.stockflowservice.domain.Usuario;
import br.com.stockflowservice.repository.UsuarioRepository;
import br.com.stockflowservice.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository UsuarioRepository;

    @Override
    public Usuario criarUsuario(Usuario usuario) {
        return UsuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> buscarTodasUsuario() {
        return UsuarioRepository.findAll();
    }

    @Override
    public Usuario buscarUmaUsuario(Long id) throws Exception {
        return UsuarioRepository.findById(id).orElseThrow(() -> new Exception("Usuario não encontrada!"));
    }

    @Override
    public Usuario alterarUsuario(Usuario usuario) throws Exception {

        if (UsuarioRepository.exists(Example.of(usuario))) {
            return UsuarioRepository.save(usuario);
        } else {
            throw new Exception("Usuario não encontrada!");
        }
    }

    @Override
    public void deletarUsuario(Long id) throws Exception {
        Usuario usuario = this.buscarUmaUsuario(id);
        UsuarioRepository.delete(usuario);
    }

    @Override
    public void deletarUsuario(Usuario usuario) throws Exception {
        Usuario usuarioEncontrado = this.buscarUmaUsuario(usuario.getId());
        UsuarioRepository.delete(usuarioEncontrado);
    }
}
