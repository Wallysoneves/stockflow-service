package br.com.stockflowservice.repository;

import br.com.stockflowservice.domain.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("estoqueRepository")
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}
