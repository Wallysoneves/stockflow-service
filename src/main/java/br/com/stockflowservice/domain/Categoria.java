package br.com.stockflowservice.domain;

import br.com.stockflowservice.domain.dto.CategoriaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
        this.dataCadastro = LocalDateTime.now();
        this.observacao = categoriaDTO.observacao();
        this.produto = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id;

    @Column(name = "nome", length = 60, nullable = false)
    private String nome;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDateTime dataCadastro;

    @Column(name = "observacao")
    private String observacao;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Produto> produto = new ArrayList<>();

}