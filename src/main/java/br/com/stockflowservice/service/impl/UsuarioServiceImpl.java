package br.com.stockflowservice.service.impl;

import br.com.stockflowservice.domain.Usuario;
import br.com.stockflowservice.domain.dto.UsuarioDTO;
import br.com.stockflowservice.exception.StockFlowException;
import br.com.stockflowservice.repository.UsuarioRepository;
import br.com.stockflowservice.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository UsuarioRepository;

    @Override
    public Usuario criarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO);
        return UsuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> buscarTodasUsuario() {
        return UsuarioRepository.findAll();
    }

    @Override
    public Usuario buscarUmUsuario(Long id) {
        return UsuarioRepository.findById(id).orElseThrow(() -> new StockFlowException("Usuario não encontrada!"));
    }

    @Override
    public Usuario buscarUmUsuario (String login, String senha) {
        return UsuarioRepository.login(login, senha).orElseThrow(() -> new StockFlowException("Usuario não cadastrado, favor entre em contato com seu supervisor para realizar o cadastrado", HttpStatus.BAD_REQUEST));
    }

    @Override
    public Usuario alterarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO);
        return UsuarioRepository.save(usuario);
    }

    @Override
    public void deletarUsuario(Long id) {
        Usuario usuario = this.buscarUmUsuario(id);
        UsuarioRepository.delete(usuario);
    }

    @Override
    public void deletarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuarioEncontrado = this.buscarUmUsuario(usuarioDTO.id());
        UsuarioRepository.delete(usuarioEncontrado);
    }
}
