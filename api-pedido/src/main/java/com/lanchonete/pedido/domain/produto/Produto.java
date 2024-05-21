package com.lanchonete.pedido.domain.produto;

import com.lanchonete.pedido.domain.categoria.Categoria;
import com.lanchonete.pedido.dto.produto.ProdutoDTO;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.*;

@Entity
@Table(name = "produto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produto_id")
    private Long produtoId;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco")
    private Double preco;

    @Column(name = "imagem")
    private String imagem;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public ProdutoDTO productDTO() {
        return ProdutoDTO.builder()
                .produtoId(produtoId)
                .nome(nome)
                .descricao(descricao)
                .preco(preco)
                .imagem(imagem)
                .categoria(categoria.getNome()).build();
    }
}