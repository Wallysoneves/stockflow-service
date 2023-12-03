package br.com.stockflowservice.repository;

import br.com.stockflowservice.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("categoriaRepository")
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query("SELECT c FROM Categoria c WHERE LOWER(c.nome) = LOWER(:nomeCategoria)")
    Optional<Categoria> findByNomeIgnoreCase(@Param("nomeCategoria") String nomeCategoria);
}
