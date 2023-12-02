package br.com.stockflowservice.domain.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
public record CategoriaDTO(Long id
                         , String nome
                         , @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
                           LocalDateTime dataCadastro
                         , String observacao) {}
