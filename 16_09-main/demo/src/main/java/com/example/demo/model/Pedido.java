package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder

public class Pedido {
    private String nomeCliente;
    private String tipoCliente;
    private BigDecimal valorOriginal;
    private BigDecimal valorComDesconto;

}
