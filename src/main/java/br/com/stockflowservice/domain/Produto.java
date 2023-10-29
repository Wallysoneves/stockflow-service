package br.com.stockflowservice.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Column(name = "nome", length = 255, nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "id_categoria")
    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria categorias;

    @Column(name = "id_estoque")
    @ManyToOne(fetch = FetchType.LAZY)
    private List<Estoque> estoques = new ArrayList<>();

    @Column(name = "preco", nullable = false)
    private BigDecimal preco;

    @Column(name = "codigo_barra", nullable = false)
    private Long codigoBarra;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDateTime dataCadastro;

    @Column(name = "data_alteracao")
    private LocalDateTime dataAlteracao;

    @Column(name = "observacao")
    private String observacao;

}
