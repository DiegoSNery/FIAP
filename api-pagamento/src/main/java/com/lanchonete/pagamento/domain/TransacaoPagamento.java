package com.lanchonete.pagamento.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "transacao_pagamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transacao_id")
    private Long transacaoId;

    @ManyToOne
    @JoinColumn(name = "pagamento_id", nullable = false)
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name = "processador_id", nullable = false)
    private ProcessadorPagamento processadorPagamento;

    @Column(name = "data_transacao", nullable = false)
    private LocalDateTime dataTransacao;

    @Column(name = "resposta_processador", nullable = false)
    private String respostaProcessador;
}