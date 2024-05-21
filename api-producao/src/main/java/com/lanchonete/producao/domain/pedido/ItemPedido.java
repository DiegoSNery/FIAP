package com.lanchonete.producao.domain.pedido;

import lombok.Data;

@Data
public class ItemPedido {

    private String produtoId;
    private String nomeProduto;
    private String descricaoProduto;
    private Double precoProduto;
    private Integer quantidade;
    private String status;
}