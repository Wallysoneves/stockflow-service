package br.com.stockflowservice.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long id;

    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @OneToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<ItemPedido> itensPedidos = new HashSet<>();

    @Column(name = "data_inicio", nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Column(name = "situacao", length = 1)
    private String situacao;
}
