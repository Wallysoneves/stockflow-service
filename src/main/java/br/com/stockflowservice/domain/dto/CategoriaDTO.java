package br.com.stockflowservice.domain.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("categoria")
public class CategoriaDTO {

    private Long id;

    private String nome;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataCadastro;

    private String observacao;
}
