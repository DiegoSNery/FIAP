package com.lanchonete.pedido.service;


import com.lanchonete.pedido.domain.categoria.Categoria;
import com.lanchonete.pedido.domain.cliente.Cliente;
import com.lanchonete.pedido.domain.produto.Produto;
import com.lanchonete.pedido.dto.produto.ProdutoDTO;
import com.lanchonete.pedido.respository.CategoriaRepository;
import com.lanchonete.pedido.respository.ClienteRepository;
import com.lanchonete.pedido.respository.PedidoRepository;
import com.lanchonete.pedido.respository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository produtoRepository;
    private final ClienteRepository clienteRepository;

    @Autowired
    public PedidoService(PedidoRepository produtoRepository, ClienteRepository clienteRepository) {
        this.produtoRepository = produtoRepository;
        this.clienteRepository = clienteRepository;
    }

    public Produto cadastrar(ProdutoDTO produtoDTO){
        Produto produto = new Produto();
        Optional<Categoria> categoria = categoriaRepository.findById(produtoDTO.getProdutoId());
        if(categoria.isPresent()) {
            produto = cadastrar(produtoDTO, categoria.get());
        }
        return produto;
    }

    public List<Produto> listar(){
        return produtoRepository.findAll();
    }


    private Produto cadastrar(ProdutoDTO produtoDTO, Categoria categoria) {
        return  produtoRepository.save(Produto.builder()
                .nome(produtoDTO.getNome())
                .descricao(produtoDTO.getDescricao())
                .preco(produtoDTO.getPreco())
                .imagem(produtoDTO.getImagem())
                .categoria(categoria).build());
    }

    public Produto atualizar(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        Optional<Categoria> categoria = categoriaRepository.findById(produtoDTO.getProdutoId());
        if (categoria.isPresent()) {
            produto = atualizar(produtoDTO, categoria.get());
        }
        return produto;
    }

    private Produto atualizar (ProdutoDTO produtoDTO, Categoria categoria) {
        return  produtoRepository.save(Produto.builder()
                .produtoId(produtoDTO.getProdutoId())
                .nome(produtoDTO.getNome())
                .descricao(produtoDTO.getDescricao())
                .preco(produtoDTO.getPreco())
                .imagem(produtoDTO.getImagem())
                .categoria(categoria).build());
    }


    public void excluir(Long id) {
        produtoRepository.deleteById(id);
    }

    public Produto detalhar(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isPresent()){ return produto.get(); }
        throw new RuntimeException("Produto não encontrado");
    }
}
