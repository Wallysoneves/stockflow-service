package br.com.stockflowservice.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProdutoDTO(Long id
                         , String nome
                         , String descricao
                         , CategoriaDTO categoriaDTO
                         , BigDecimal preco
                         , Long CodigoBarra
                         , LocalDateTime dataAlteracao
                         , String observacao
                         ) {}
