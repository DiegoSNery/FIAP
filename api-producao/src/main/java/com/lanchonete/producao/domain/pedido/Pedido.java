package com.lanchonete.producao.domain.pedido;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "pedidos")
@Data
public class Pedido {
    @Id
    private String id;
    private String clienteId;
    private LocalDateTime dataPedido;
    private String status;
    private List<ItemPedido> itensPedido;
    private LocalDateTime tempoEstimado;
}
