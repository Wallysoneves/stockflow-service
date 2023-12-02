package br.com.stockflowservice.domain.id;

import br.com.stockflowservice.domain.Pedido;
import br.com.stockflowservice.domain.Produto;
import br.com.stockflowservice.domain.dto.ItemPedidoIdDTO;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@Embeddable
public class ItemPedidoId {

    @ManyToOne
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    private Pedido pedido;

}
