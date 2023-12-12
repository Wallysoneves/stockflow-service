package br.com.stockflowservice.domain.id;

import br.com.stockflowservice.domain.Pedido;
import br.com.stockflowservice.domain.Produto;
import br.com.stockflowservice.domain.dto.ItemPedidoIdDTO;
import br.com.stockflowservice.domain.dto.PedidoDTO;
import br.com.stockflowservice.domain.dto.ProdutoDTO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@Embeddable
public class ItemId implements Serializable {

    @ManyToOne
    @MapsId("pedidoId")
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @MapsId("produtoId")
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public ItemId(ItemPedidoIdDTO itemPedidoIdDTO) {
        this.pedido = new Pedido(itemPedidoIdDTO.getPedidoDTO());
        this.produto = new Produto(itemPedidoIdDTO.getProdutoDTO());
    }

}
