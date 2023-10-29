package br.com.stockflowservice.domain;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "id_produto")
    @OneToMany(fetch = FetchType.LAZY)
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

}
