package br.com.stockflowservice.domain;

import br.com.stockflowservice.domain.dto.EstoqueDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "estoques")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_estoque")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Produto produto;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "data_entrada")
    private LocalDateTime dataEntrada;

    @Column(name = "preco_compra", nullable = false)
    private BigDecimal precoCompra;

    @Column(name = "preco_venda", nullable = false)
    private BigDecimal precoVenda;

    @Column(name = "situacao", length = 1)
    private String situacao;

    public Estoque (EstoqueDTO estoqueDTO) {
        this.id = estoqueDTO.getId();
        this.quantidade = estoqueDTO.getQuantidade();
        this.dataEntrada = Objects.nonNull(estoqueDTO.getDataEntrada()) ? estoqueDTO.getDataEntrada() : LocalDateTime.now();
        this.precoCompra = estoqueDTO.getPrecoCompra();
        this.precoVenda = estoqueDTO.getPrecoVenda();
        this.situacao = estoqueDTO.getSituacao();
    }
}
