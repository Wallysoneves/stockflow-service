package br.com.stockflowservice.repository;

import br.com.stockflowservice.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("pedidoRepository")
public interface PedidoRepository  extends JpaRepository<Pedido, Long> {

    @Query(value =  "SELECT p.numero + 1        " +
                    "   FROM pedidos p          " +
                    " ORDER BY p.id DESC        " +
                    "   LIMIT 1                 ", nativeQuery = true)
    Optional<Long> buscarUltimoNumeroPedido();
}
