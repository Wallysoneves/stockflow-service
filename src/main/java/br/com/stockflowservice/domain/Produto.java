package br.com.stockflowservice.domain;

import br.com.stockflowservice.domain.dto.ProdutoDTO;
import br.com.stockflowservice.domain.dto.UsuarioDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_produto")
    private Long id;

    @Column(name = "nome", length = 254, nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria categoria;

    @Column(name = "preco", nullable = false)
    private BigDecimal preco;

    @Column(name = "codigo_barra", nullable = false)
    private Long codigoBarra;

    @Column(name = "data_cadastro")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataCadastro;

    @Column(name = "data_alteracao")
    private LocalDateTime dataAlteracao;

    @Column(name = "observacao")
    private String observacao;

    public Produto (ProdutoDTO produtoDTO) {
        this.id = produtoDTO.id();
        this.nome = produtoDTO.nome();
        this.descricao = produtoDTO.descricao();
        this.preco = produtoDTO.preco();
        this.codigoBarra = produtoDTO.codigoBarra();
        this.dataCadastro = Objects.nonNull(produtoDTO.dataCadastro()) ? produtoDTO.dataCadastro() : LocalDateTime.now();
        this.observacao = produtoDTO.observacao();
    }

}
