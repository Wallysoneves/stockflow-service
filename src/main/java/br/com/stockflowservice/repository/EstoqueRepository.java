package br.com.stockflowservice.repository;

import br.com.stockflowservice.domain.Estoque;
import br.com.stockflowservice.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("estoqueRepository")
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

    @Query(value =  "SELECT E.*                                                     " +
                    "   FROM ESTOQUES E                                             " +
                    " INNER JOIN PRODUTOS P ON (P.ID = E.PRODUTO_ID)                " +
                    " WHERE P.CODIGO_BARRA = :codigoBarra                           ", nativeQuery = true)
    Optional<Estoque> buscarEstoqueCodigoBarra(@Param("codigoBarra") Long codigoBarra);

    Optional<Estoque> findByProduto(Produto produto);
}
