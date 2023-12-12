package br.com.stockflowservice.domain;
import br.com.stockflowservice.domain.dto.ItemPedidoDTO;
import br.com.stockflowservice.domain.id.ItemId;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "itens")
public class Item {

    @EmbeddedId
    private ItemId id;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "preco_unitario", nullable = false)
    private BigDecimal precoUnitario;

    @Column(name = "total_item", nullable = false)
    private BigDecimal total;

    public Item(ItemPedidoDTO itemPedidoDTO) {

        this.id = new ItemId(itemPedidoDTO.getId());

        this.precoUnitario = itemPedidoDTO.getPrecoUnitario();
        this.quantidade = itemPedidoDTO.getQuantidade();
        this.total = itemPedidoDTO.getTotal();
    }
}
