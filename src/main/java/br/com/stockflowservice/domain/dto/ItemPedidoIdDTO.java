package br.com.stockflowservice.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("itemPedidoId")
public class ItemPedidoIdDTO {

    @JsonProperty("produto")
    private ProdutoDTO produtoDTO;

    @JsonProperty("pedido")
    private PedidoDTO pedidoDTO;
}
