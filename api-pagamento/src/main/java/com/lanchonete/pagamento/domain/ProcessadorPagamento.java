package com.lanchonete.pagamento.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "processador_pagamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcessadorPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "processador_id")
    private Long processadorId;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo;

    @OneToMany(mappedBy = "processadorPagamento")
    private List<TransacaoPagamento> transacoes;
}