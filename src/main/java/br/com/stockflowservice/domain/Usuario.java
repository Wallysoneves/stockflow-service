package br.com.stockflowservice.domain;

import br.com.stockflowservice.domain.dto.UsuarioDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", length = 120, nullable = false)
    private String nome;

    @Column(name = "email", length = 120, nullable = false)
    private String email;

    @Column(name = "login", length = 120, nullable = false)
    private String login;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "data_alteracao")
    private LocalDateTime dataAlteracao;

    public Usuario (UsuarioDTO usuarioDTO) {

        this.id = usuarioDTO.getId();
        this.nome = usuarioDTO.getNome();
        this.email = usuarioDTO.getEmail();
        this.login = usuarioDTO.getLogin();
        this.senha = usuarioDTO.getSenha();
        this.dataCadastro = LocalDateTime.now();
        this.dataNascimento = usuarioDTO.getDataNascimento();
        this.dataAlteracao = LocalDateTime.now();
    }

}
