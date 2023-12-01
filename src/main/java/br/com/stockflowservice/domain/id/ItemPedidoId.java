package br.com.stockflowservice.domain.id;

import br.com.stockflowservice.domain.ItemPedido;
import br.com.stockflowservice.domain.Pedido;
import br.com.stockflowservice.domain.Produto;
import br.com.stockflowservice.domain.dto.ItemPedidoDTO;
import br.com.stockflowservice.domain.dto.ItemPedidoIdDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.modelmapper.ModelMapper;

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

    public static ItemPedidoId convert(ItemPedidoIdDTO itemPedidoIdDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(itemPedidoIdDTO, ItemPedidoId.class);
    }
}
