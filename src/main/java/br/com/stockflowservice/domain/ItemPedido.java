package br.com.stockflowservice.domain;

import br.com.stockflowservice.domain.dto.EstoqueDTO;
import br.com.stockflowservice.domain.dto.ItemPedidoDTO;
import br.com.stockflowservice.domain.id.ItemPedidoId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
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

    public static ItemPedido convert(ItemPedidoDTO itemPedidoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(itemPedidoDTO, ItemPedido.class);
    }
}
