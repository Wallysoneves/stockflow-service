package br.com.stockflowservice.domain.id;

import br.com.stockflowservice.domain.Pedido;
import br.com.stockflowservice.domain.Produto;
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

}
