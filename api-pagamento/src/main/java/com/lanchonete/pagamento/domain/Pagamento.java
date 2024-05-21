package com.lanchonete.pagamento.domain;

import com.lanchonete.pagamento.domain.pedido.Pedido;
import com.lanchonete.pagamento.enums.StatusPagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pagamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pagamento_id")
    private Long pagamentoId;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Column(name = "data_pagamento", nullable = false)
    private LocalDateTime dataPagamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_pagamento", nullable = false)
    private StatusPagamento statusPagamento;

    @OneToMany(mappedBy = "pagamento")
    private List<TransacaoPagamento> transacoes;
}