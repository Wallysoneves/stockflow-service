package br.com.stockflowservice.repository;

import br.com.stockflowservice.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("produtoRepository")
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query(value =  "SELECT P.*                                         " +
                    "   FROM PRODUTOS P                                 " +
                    " WHERE P.NOME LIKE '%:texto%' OR                   " +
                    "   AND P.DESCRICAO LIKE '%:texto%' OR              " +
                    "   AND P.CODIGO_BARRA = CAST(:texto AS INTEGER)    ", nativeQuery = true)
    Optional<List<Produto>> buscarCampoPesquisa(@Param("texto") String texto);
}
