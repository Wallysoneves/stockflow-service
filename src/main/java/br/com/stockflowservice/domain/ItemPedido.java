package br.com.stockflowservice.domain;

import br.com.stockflowservice.domain.id.ItemPedidoId;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "itens_pedidos")
public class ItemPedido {

    @EmbeddedId
    private ItemPedidoId id;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "preco_unitario", nullable = false)
    private BigDecimal precoUnitario;

    @Column(name = "total_item", nullable = false)
    private BigDecimal total;
}
