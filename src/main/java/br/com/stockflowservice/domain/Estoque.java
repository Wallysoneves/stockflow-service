package br.com.stockflowservice.domain;

import br.com.stockflowservice.domain.dto.EstoqueDTO;
import br.com.stockflowservice.domain.dto.PedidoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "estoques")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_estoque")
    private Long id;

    @JoinColumn(name = "id_produto")
    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Produto produto;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "data_entrada", nullable = false)
    private LocalDateTime dataEntrada;

    @Column(name = "preco_compra", nullable = false)
    private BigDecimal precoCompra;

    @Column(name = "preco_venda", nullable = false)
    private BigDecimal precoVenda;

    @Column(name = "situacao", length = 1)
    private String situacao;

    public static Estoque convert(EstoqueDTO estoqueDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(estoqueDTO, Estoque.class);
    }
}
