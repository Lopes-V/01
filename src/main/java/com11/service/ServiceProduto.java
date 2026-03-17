package com11.service;

import com11.DTO.DTOProduto;
import com11.model.Produto;
import com11.repository.RepositoryProduto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ServiceProduto extends RepositoryProduto{
    // Método para obter todos os produtos
     default List<Produto> getProduto(){
        return findAll();
    }
    // Método para criar um novo produto a partir de um DTO
     default boolean createProduto(DTOProduto dtoProduto){
        try{
            save(Produto.builder().nome(dtoProduto.nomeProduto()).build());
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }
    // Método para deletar um produto pelo ID
     default boolean deletarPessoas(Long id){
        try{
            deleteById(id);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }
    // Método para atualizar o nome de um produto existente, identificada pelo ID
     default boolean atualizarPessoas(Long id, String nomeNovo){
        try {
            Produto p = findById(id).orElseThrow();
            p.setNome(nomeNovo);
            save(p);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }
}
