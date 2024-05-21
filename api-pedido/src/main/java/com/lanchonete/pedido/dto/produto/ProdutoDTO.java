package com.lanchonete.pedido.dto.produto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private Long produtoId;

    private String nome;

    private String descricao;

    private Double preco;

    private String imagem;

    private String categoriaId;

    private String categoria;



}
