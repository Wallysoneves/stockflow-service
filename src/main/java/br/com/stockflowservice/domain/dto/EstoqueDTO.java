package br.com.stockflowservice.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("estoque")
public class EstoqueDTO {

    private Long id;

    private Integer quantidade;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataEntrada;

    private BigDecimal precoCompra;

    private BigDecimal precoVenda;

    private String situacao;

    @JsonProperty("produto")
    private ProdutoDTO produtoDTO;
}
