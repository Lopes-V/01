package com11.controller;

import com11.DTO.DTOPedido;
import com11.model.Pedido;
import com11.service.ServicePedido;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/pedido")
public abstract class ControllerPedido {
    private final ServicePedido sp;
    // Endpoint para pegar todos os pedidos
    @GetMapping()
    public ResponseEntity<List<Pedido>> pegarPedido(){
        return ResponseEntity.ok(sp.getPedido());
    }

    // Endpoint para criar um novo pedido
    @PostMapping("/criar")
    public ResponseEntity<?> criarPedido(@RequestBody DTOPedido dtoPedido){
        if(sp.createPedido(dtoPedido)){
            return ResponseEntity.ok(Map.of("message", "Pedido criado com sucesso"));
        } else {
            return ResponseEntity.badRequest().body(Map.of("message", "Erro ao criar pedido"));
        }
    }

    // Endpoint para deletar um pedido
    @DeleteMapping("/deletar")
    public ResponseEntity<?> deletaPedido(@RequestBody Long id){
        if(sp.deletarPedido(id)){
            return ResponseEntity.ok(Map.of("message", "Pedido deletado com sucesso"));
        } else {
            return ResponseEntity.badRequest().body(Map.of("message", "Erro ao deletar pedido"));
        }
    }
}
