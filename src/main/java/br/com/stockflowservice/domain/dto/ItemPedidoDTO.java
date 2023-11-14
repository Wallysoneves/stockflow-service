package br.com.stockflowservice.domain.dto;

import java.math.BigDecimal;

public record ItemPedidoDTO(ItemPedidoIdDTO id
                            , Integer quantidade
                            , BigDecimal precoUnitario
                            , BigDecimal total
                            ) {
}
