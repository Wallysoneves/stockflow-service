package br.com.stockflowservice.domain.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record EstoqueDTO( Long id
                        , Integer quantidade
                        , LocalDateTime dataEntrada
                        , BigDecimal precoCompra
                        , BigDecimal precoVenda
                        , String situacao
                        , ProdutoDTO produtoDTO
                         ) {}
