package br.com.stockflowservice.domain.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("usuario")
public class UsuarioDTO {

    private Long id;

    private String nome;

    private String email;

    private String login;

    private String senha;

    private LocalDateTime dataCadastro;

    private LocalDate dataNascimento;
}
