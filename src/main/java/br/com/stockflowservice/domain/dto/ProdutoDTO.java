package br.com.stockflowservice.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProdutoDTO(Long id
                         , String nome
                         , String descricao
                         , @Schema(name = "categoria") CategoriaDTO categoriaDTO
                         , BigDecimal preco
                         , Long codigoBarra
                         , @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
                            LocalDateTime dataCadastro
                         , @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
                            LocalDateTime dataAlteracao
                         , String observacao
                         ) {}
