package com11.service;

import com11.DTO.DTOPessoa;
import com11.DTO.DTOProduto;
import com11.model.Pessoa;
import com11.model.Produto;
import com11.repository.RepositoryProduto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
public class ServiceProduto {
    RepositoryProduto rp;

    public List<Produto> getProduto(){
        return rp.findAll();
    }
    public void createProduto(DTOProduto dtoProduto){
        rp.save(Produto.builder().nome(dtoProduto.nome()).build());
    }
    public void deletarPessoas(Long id){
        rp.deleteById(id);
    }
    public void atualizarPessoas(Long id, String nomeNovo){
        Produto p = rp.findById(id).orElseThrow();
        p.setNome(nomeNovo);
        rp.save(p);
    }
}
