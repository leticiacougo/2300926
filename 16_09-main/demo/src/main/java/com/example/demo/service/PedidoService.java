package com.example.demo.service;

import com.example.demo.model.Pedido;
import com.example.demo.strategy.DescontoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PedidoService {
    private final Map<String, DescontoStrategy> estrategiasDeDesconto= new HashMap<>();
    @Autowired
    public PedidoService (List<DescontoStrategy> strategies){
        for (DescontoStrategy strategy : strategies) {
            estrategiasDeDesconto.put(strategy.getPerfilCliente().toUpperCase(), strategy);
        }
    }

    public Pedido processarPedido(String nomeCliente, String perfilCliente, BigDecimal valorTotal){
        DescontoStrategy strategy=estrategiasDeDesconto.get(perfilCliente.toUpperCase());

        BigDecimal valorFinal= valorTotal;

        if (strategy != null){
            valorFinal=strategy.aplicarDesconto(valorTotal);
        }

        return PedidoBuilder()
                .nomeCiente(nomeCliente);


    }


}
