package com11.service;
//FEITO ATE AQUI
import com11.DTO.DTOPessoa;
import com11.model.Pessoa;
import com11.repository.RepositoryPessoa;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ServicePessoa extends RepositoryPessoa {
    // Método para obter todas as pessoas
     default List<Pessoa> getPessoas(){
        return findAll();
    }
    // Método para criar uma nova pessoa a partir de um DTO
     default boolean createPessoas(DTOPessoa dtoPessoa){
         try{
                save(Pessoa.builder().nome(dtoPessoa.nome()).build());
                return true;
            } catch (Exception e) {
             e.printStackTrace();
             return false;
         }
    }
    // Método para deletar uma pessoa pelo ID
     default boolean deletarPessoas(UUID id){
        try {
            deleteById(id);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }
    // Método para atualizar o nome de uma pessoa existente, identificada pelo ID
     default boolean atualizarPessoas(UUID id, String nomeNovo){
        try {
            Pessoa pessoa = findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
            pessoa.setNome(nomeNovo);
            save(pessoa);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }
}