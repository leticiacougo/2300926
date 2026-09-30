package com.example.demo.Contoller;


import com.example.demo.model.Pedido;
import com.example.demo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping ("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/checkout")
    public ResponseEntity<Pedido> realizarCheckout (
            @RequestParam String nome,
            @RequestParam String perfil,
            @RequestParam BigDecimal valor){

        Pedido pedidoProcessado = pedidoService.processarPedido(nome, perfil, valor);
        return ResponseEntity.ok(pedidoProcessado);
    }

}
