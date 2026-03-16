package com11.service;

import com11.DTO.DTOPedido;
import com11.model.Pedido;
import com11.repository.RepositoryPedido;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public interface ServicePedido extends RepositoryPedido {
    // Método para obter todos os pedidos
    default List<DTOPedido> getPedido(){
        return findAll().stream()
                .map(p -> new DTOPedido(p.getId(), p.getIdProduto(), p.getIdPessoa()))
                .collect(Collectors.toList());
    }
    // Método para criar um novo pedido a partir de um DTO
    default boolean createPedido(DTOPedido dtoPedido){
        try {
            save(Pedido.builder().idPessoa(dtoPedido.idPessoa()).idProduto(dtoPedido.idProduto()).build());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    // Método para atualizar um pedido existente, modificando os campos idPessoa e idProduto
    default boolean deletarPedido(Long id){
        try{
            deleteById(id);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }
}