package br.com.stockflowservice.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("pedido")
public class PedidoDTO {

    private Long id;
    private Long numeroPedido;

    @JsonProperty("usuario")
    private UsuarioDTO usuarioDTO;

    private LocalDateTime dataInicio;

    private BigDecimal valorTotal;

    private String situacao;

}