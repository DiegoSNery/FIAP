package com.lanchonete.pedido.respository;

import com.lanchonete.pedido.domain.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {
}
