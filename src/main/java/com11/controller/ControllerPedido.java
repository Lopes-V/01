package com11.controller;

import com11.DTO.DTOPedido;
import com11.model.Pedido;
import com11.service.ServicePedido;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ControllerPedido {
    final ServicePedido sp ;

    @GetMapping("/pedido")
    public List<Pedido> getPedido(){
        return sp.getPedido();
    }
    @PostMapping("/pedido/criar")
    public void createPedido(@RequestBody DTOPedido dtoPedido){
        sp.createPedido(dtoPedido);
    }
    @DeleteMapping("/pedido/deletar")
    public void deletarPedido(@RequestBody Long id){
        sp.deletarPedido(id);
    }
}
