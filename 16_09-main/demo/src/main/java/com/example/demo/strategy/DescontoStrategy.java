package com.example.demo.strategy;
import java.math.BigDecimal;

public interface DescontoStrategy {
    BigDecimal aplicarDesconto(BigDecimal valorOriginal);
    String getPerfilCliente();
}
