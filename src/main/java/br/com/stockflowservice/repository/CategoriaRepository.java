package br.com.stockflowservice.repository;

import br.com.stockflowservice.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("categoriaRepository")
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
