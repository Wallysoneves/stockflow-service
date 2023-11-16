package br.com.stockflowservice.domain;

import br.com.stockflowservice.domain.dto.CategoriaDTO;
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
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "categorias")
public class Categoria {

    public Categoria (CategoriaDTO categoriaDTO) {
        this.id = categoriaDTO.id();
        this.nome = categoriaDTO.nome();
        this.dataCadastro = Objects.nonNull(categoriaDTO.dataCadastro()) ? categoriaDTO.dataCadastro() : LocalDateTime.now();
        this.observacao = categoriaDTO.observacao();
        this.produtos = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id;

    @Column(name = "nome", length = 60, nullable = false)
    private String nome;

    @Column(name = "data_cadastro", nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataCadastro;

    @Column(name = "observacao")
    private String observacao;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Produto> produtos = new ArrayList<>();

}