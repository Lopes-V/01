package com11.service;

import com11.DTO.DTOPessoa;
import com11.model.Pessoa;
import com11.repository.RepositoryPessoa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ServicePessoa {
    final RepositoryPessoa rp;

    public List<Pessoa> getPessoas(){
        return rp.findAll();
    }
    public void createPessoas(DTOPessoa dtoPessoa){
        rp.save(Pessoa.builder().nome(dtoPessoa.nome()).build());
    }
    public void deletarPessoas(UUID id){
        rp.deleteById(id);
    }
    public void atualizarPessoas(UUID id, String nomeNovo){
        Pessoa p = rp.findById(id).orElseThrow();
        p.setNome(nomeNovo);
        rp.save(p);
    }
}