package com.example.demo.strategy.impl;

import com.example.demo.strategy.DescontoStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

public class DescontoVip implements DescontoStrategy {
    @Override
    public BigDecimal aplicarDesconto(BigDecimal valorOriginal){
        BigDecimal fatorDesconto= new BigDecimal("0.85");
        return valorOriginal.multiply(fatorDesconto);
    }

    @Override
    public String getPerfilCliente{
        return "ESTUDANTE";
    }
}
