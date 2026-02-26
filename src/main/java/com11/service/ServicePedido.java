package com11.service;

import com11.DTO.DTOPedido;
import com11.model.Pedido;
import com11.repository.RepositoryPedido;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicePedido {
    RepositoryPedido rp;
    public List<Pedido> getPedido(){
        return rp.findAll();
    }
    public void createPedido(DTOPedido dtoPedido){
        rp.save(Pedido.builder().idPessoa(dtoPedido.idPessoa()).idProduto(dtoPedido.idProduto()).build());
    }
    public void deletarPedido(Long id){
        rp.deleteById(id);
    }
}