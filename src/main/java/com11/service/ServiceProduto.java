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
     default void createProduto(DTOProduto dtoProduto){
        save(Produto.builder().nome(dtoProduto.nome()).build());
    }
    // Método para deletar um produto pelo ID
     default void deletarPessoas(Long id){
        deleteById(id);
    }
    // Método para atualizar o nome de um produto existente, identificada pelo ID
     default void atualizarPessoas(Long id, String nomeNovo){
        Produto p = findById(id).orElseThrow();
        p.setNome(nomeNovo);
        save(p);
    }
}
