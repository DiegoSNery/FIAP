package com.lanchonete.pedido.respository;

import com.lanchonete.pedido.domain.categoria.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
}
