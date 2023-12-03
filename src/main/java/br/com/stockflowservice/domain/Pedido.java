package br.com.stockflowservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "numero", unique = true)
    private Long numeroPedido;

    @JoinColumn(name = "usuario_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @Column(name = "data_geracao", nullable = false)
    private LocalDateTime dataGeracao;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Column(name = "situacao", length = 1)
    private String situacao;
}
