package br.com.stockflowservice.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public record PedidoDTO(Long id
                        , @Schema(name = "usuario") UsuarioDTO usuarioDTO
                        , @Schema(name = "ItemPedido") Set<ItemPedidoDTO> itemPedidoDTOS
                        , LocalDateTime dataInicio
                        , BigDecimal valorTotal
                        , String situacao
                        ) {}
