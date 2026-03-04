package com11.controller;

import com11.DTO.DTOPedido;
import com11.interfaceService.InterPedido;
import com11.model.Pedido;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/pedido")
public abstract class ControllerPedido extends InterPedido {
    // Endpoint para criar um novo pedido'
    @GetMapping()
    public List<Pedido> getPedido(){
        return getPedido();
    }

    // Endpoint para criar um novo pedido
    @PostMapping("criar")
    public void createPedido(@RequestBody DTOPedido dtoPedido){
        createPedido(dtoPedido);
    }

    // Endpoint para deletar um pedido
    @DeleteMapping("/deletar")
    public void deletarPedido(@RequestBody Long id){
        deletarPedido(id);
    }
}
