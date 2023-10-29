package br.com.stockflowservice.repository;

import br.com.stockflowservice.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("usuariorepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
