package com11.service;

import com11.DTO.DTOPessoa;
import com11.model.Pessoa;
import com11.repository.RepositoryPessoa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicePessoa {
    final RepositoryPessoa rp;

    public List<Pessoa> getPessoas(){
        return rp.findAll();
    }
    public void createPessoas(DTOPessoa dtoPessoa){
        rp.save(new Pessoa(dtoPessoa.nome()));
    }
}