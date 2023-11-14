package br.com.stockflowservice.domain.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UsuarioDTO(Long id
                        , String nome
                        , String email
                        , String login
                        , String senha
                        , LocalDateTime dataCadastro
                        , LocalDate dataNascimento
                         ) {}
