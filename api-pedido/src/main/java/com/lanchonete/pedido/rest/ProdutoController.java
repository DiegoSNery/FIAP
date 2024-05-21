package com.lanchonete.pedido.rest;

import com.lanchonete.pedido.domain.produto.Produto;
import com.lanchonete.pedido.dto.produto.ProdutoDTO;
import com.lanchonete.pedido.service.ProdutoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> cadastrarProduto (@RequestBody ProdutoDTO request) {
        //ProdutoDTO produto = produtoService.cadastrarProduto(request);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody ProdutoDTO request, UriComponentsBuilder uriBuilder) {
        var produto = produtoService.cadastrar(request);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(produto.getProdutoId()).toUri();
        return ResponseEntity.created(uri).body(produto.productDTO());
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listar() {
        var produtos  = produtoService.listar().stream().map(produto -> produto.productDTO()).toList();
        return ResponseEntity.ok(produtos);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody ProdutoDTO request) {
        var produto = produtoService.atualizar(request);
        return ResponseEntity.ok(produto.productDTO());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        produtoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var produto = produtoService.detalhar(id);
        return ResponseEntity.ok(produto.productDTO());
    }


}
