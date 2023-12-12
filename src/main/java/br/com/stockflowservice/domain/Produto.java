package br.com.stockflowservice.domain;

import br.com.stockflowservice.domain.dto.ProdutoDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", length = 254, nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
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
        this.id = produtoDTO.getId();
        this.nome = produtoDTO.getNome();
        this.descricao = produtoDTO.getDescricao();
        this.preco = produtoDTO.getPreco();
        this.categoria = new Categoria(produtoDTO.getCategoriaDTO());
        this.codigoBarra = produtoDTO.getCodigoBarra();
        this.dataCadastro = Objects.nonNull(produtoDTO.getDataCadastro()) ? produtoDTO.getDataCadastro() : LocalDateTime.now();
        this.observacao = produtoDTO.getObservacao();
    }

}
