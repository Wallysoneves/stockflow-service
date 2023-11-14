package br.com.stockflowservice.domain;

import br.com.stockflowservice.domain.dto.ProdutoDTO;
import br.com.stockflowservice.domain.dto.UsuarioDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;

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

    @Column(name = "nome", length = 254, nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Categoria categoria;

    @OneToOne(mappedBy = "produto", fetch = FetchType.LAZY)
    private Estoque estoque;

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

    public static Produto convert(ProdutoDTO produtoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(produtoDTO, Produto.class);
    }

}
