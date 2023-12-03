package br.com.stockflowservice.repository;

import br.com.stockflowservice.domain.Item;
import br.com.stockflowservice.domain.id.ItemId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("itemPedidoRepository")
public interface ItemPedidoRepository extends JpaRepository<Item, ItemId> {
}
