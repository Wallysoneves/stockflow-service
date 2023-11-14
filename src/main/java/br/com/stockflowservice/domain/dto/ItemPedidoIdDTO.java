package br.com.stockflowservice.domain.dto;

public record ItemPedidoIdDTO(ProdutoDTO produtoDTO
                            , PedidoDTO pedidoDTO
                              ) {}
