package br.com.stockflowservice.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "itens_pedidos")
public class ItemPedido {

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "id_pedido")
    private Set<Pedido> pedidos = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "id_produto")
    private Produto produto;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "preco_unitario", nullable = false)
    private BigDecimal precoUnitario;

    @Column(name = "total_item", nullable = false)
    private BigDecimal total;
}
