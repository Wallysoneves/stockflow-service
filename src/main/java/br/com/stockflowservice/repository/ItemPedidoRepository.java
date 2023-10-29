package br.com.stockflowservice.repository;

import br.com.stockflowservice.domain.ItemPedido;
import br.com.stockflowservice.domain.id.ItemPedidoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("itemPedidoRepository")
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoId> {
}
