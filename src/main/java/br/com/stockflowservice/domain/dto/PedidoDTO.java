package br.com.stockflowservice.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("pedido")
public class PedidoDTO {

    private Long id;

    @JsonProperty("usuario")
    private UsuarioDTO usuarioDTO;

    @JsonProperty("itemPedido")
    private Set<ItemPedidoDTO> itemPedidoDTOS;

    private LocalDateTime dataInicio;

    private BigDecimal valorTotal;

    private String situacao;

}