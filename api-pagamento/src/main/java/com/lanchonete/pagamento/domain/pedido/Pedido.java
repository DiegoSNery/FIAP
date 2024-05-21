package com.lanchonete.pagamento.domain.pedido;

import com.lanchonete.pagamento.domain.Pagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_id")
    private Long pedidoId;

    @Column(name = "ticket", nullable = false)
    private Long ticket;

    @Column(name = "cliente_id", nullable = false)
    private Integer clienteId;

    @Column(name = "data_pedido", nullable = false)
    private LocalDateTime dataPedido;

    @OneToMany(mappedBy = "pedido")
    private List<Pagamento> pagamentos;
}

