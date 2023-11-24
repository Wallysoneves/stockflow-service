package br.com.stockflowservice.repository;

import br.com.stockflowservice.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("usuariorepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = " SELECT *                                           " +
                   "    FROM USUARIOS U                                 " +
                   "  WHERE (U.LOGIN = :login) AND (U.SENHA = :senha)   " +
                   "    OR  (U.EMAIL = :login) AND (U.SENHA = :senha)   ", nativeQuery = true)
    Optional<Usuario> login(@Param("login") String login, @Param("senha") String senha);
}
