package com.lanchonete.producao.repository;

import com.lanchonete.producao.domain.pedido.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidoRepository extends MongoRepository<Pedido, String> {
}
