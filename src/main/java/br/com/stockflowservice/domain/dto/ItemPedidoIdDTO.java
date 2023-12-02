package br.com.stockflowservice.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record ItemPedidoIdDTO(@Schema(name = "produto") ProdutoDTO produtoDTO
                            , @Schema(name = "pedido") PedidoDTO pedidoDTO
                              ) {}
