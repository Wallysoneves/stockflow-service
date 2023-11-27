package br.com.stockflowservice.domain;

import br.com.stockflowservice.domain.dto.EstoqueDTO;
import br.com.stockflowservice.domain.dto.PedidoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDate;
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
        this.id = estoqueDTO.id();
        this.quantidade = estoqueDTO.quantidade();
        this.dataEntrada = Objects.nonNull(estoqueDTO.dataEntrada()) ? estoqueDTO.dataEntrada() : LocalDateTime.now();
        this.precoCompra = estoqueDTO.precoCompra();
        this.precoVenda = estoqueDTO.precoVenda();
        this.situacao = estoqueDTO.situacao();
    }
}
