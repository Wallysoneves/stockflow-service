package br.com.stockflowservice.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
                        , @Schema(name = "produto") ProdutoDTO produtoDTO
                         ) {}
