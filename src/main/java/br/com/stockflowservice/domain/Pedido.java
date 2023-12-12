package br.com.stockflowservice.domain;

import br.com.stockflowservice.domain.dto.PedidoDTO;
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

    @Column(name = "data_geracao")
    private LocalDateTime dataGeracao;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Column(name = "situacao", length = 1)
    private String situacao;

    public Pedido (PedidoDTO pedidoDTO) {
        this.id = pedidoDTO.getId();
        this.numeroPedido = pedidoDTO.getNumeroPedido();
        this.dataGeracao = LocalDateTime.now();
        this.usuario = new Usuario(pedidoDTO.getUsuarioDTO());
        this.situacao = pedidoDTO.getSituacao();
        this.valorTotal = pedidoDTO.getValorTotal();
    }
}
