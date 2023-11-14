package br.com.stockflowservice.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record EstoqueDTO( Long id
                        , Integer quantidade
                        , LocalDateTime dataEntrada
                        , BigDecimal precoCompra
                        , BigDecimal precoVenda
                        , String situacao
                        , ProdutoDTO produtoDTO
                         ) {}
