package br.com.stockflowservice.domain;

import br.com.stockflowservice.domain.dto.CategoriaDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", length = 60, nullable = false)
    private String nome;

    @Column(name = "data_cadastro", nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataCadastro;

    @Column(name = "observacao")
    private String observacao;

    public Categoria (CategoriaDTO categoriaDTO) {
        this.id = categoriaDTO.getId();
        this.nome = categoriaDTO.getNome();
        this.dataCadastro = Objects.nonNull(categoriaDTO.getDataCadastro()) ? categoriaDTO.getDataCadastro() : LocalDateTime.now();
        this.observacao = categoriaDTO.getObservacao();
    }

}