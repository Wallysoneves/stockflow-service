package br.com.stockflowservice.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public record PedidoDTO(Long id
                        , UsuarioDTO usuarioDTO
                        , Set<ItemPedidoDTO> itemPedidoDTOS
                        , LocalDateTime dataInicio
                        , BigDecimal valorTotal
                        , String situacao
                        ) {}
