package com.lanchonete.pedido.respository;

import com.lanchonete.pedido.domain.produto.Produto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

    List<Produto> findAll();
}
