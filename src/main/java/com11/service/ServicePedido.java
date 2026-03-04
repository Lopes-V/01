package com11.service;

import com11.DTO.DTOPedido;
import com11.model.Pedido;
import com11.repository.RepositoryPedido;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServicePedido extends RepositoryPedido {
    // Método para obter todos os pedidos
    default List<Pedido> getPedido(){return findAll();}
    // Método para criar um novo pedido a partir de um DTO
    default void createPedido(DTOPedido dtoPedido){
        save(Pedido.builder().idPessoa(dtoPedido.idPessoa()).idProduto(dtoPedido.idProduto()).build());
    }
    // Método para atualizar um pedido existente, modificando os campos idPessoa e idProduto
    default void deletarPedido(Long id){
        deleteById(id);
    }
}