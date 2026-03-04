package com11.service;

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
     default void createPessoas(DTOPessoa dtoPessoa){
        save(Pessoa.builder().nome(dtoPessoa.nome()).build());
    }
    // Método para deletar uma pessoa pelo ID
     default void deletarPessoas(UUID id){
        deleteById(id);
    }
    // Método para atualizar o nome de uma pessoa existente, identificada pelo ID
     default void atualizarPessoas(UUID id, String nomeNovo){
        Pessoa p = findById(id).orElseThrow();
        p.setNome(nomeNovo);
        save(p);
    }
}