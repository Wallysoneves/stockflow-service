package br.com.stockflowservice.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoDTO {

    @JsonProperty("itemPedidoId")
    private ItemPedidoIdDTO id;

    private Integer quantidade;

    private BigDecimal precoUnitario;

    private BigDecimal total;
}
