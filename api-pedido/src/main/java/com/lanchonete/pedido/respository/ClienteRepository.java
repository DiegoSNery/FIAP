package com.lanchonete.pedido.respository;

import com.lanchonete.pedido.domain.cliente.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
