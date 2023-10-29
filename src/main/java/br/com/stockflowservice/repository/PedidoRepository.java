package br.com.stockflowservice.repository;

import br.com.stockflowservice.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("pedidoRepository")
public interface PedidoRepository  extends JpaRepository<Pedido, Long> {
}
