package br.com.stockflowservice.domain;

import br.com.stockflowservice.domain.dto.PedidoDTO;
import br.com.stockflowservice.domain.dto.ProdutoDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;

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
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long id;

    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @OneToMany(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<ItemPedido> itensPedidos = new HashSet<>();

    @Column(name = "data_inicio", nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Column(name = "situacao", length = 1)
    private String situacao;

    public static Pedido convert(PedidoDTO pedidoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(pedidoDTO, Pedido.class);
    }
}
