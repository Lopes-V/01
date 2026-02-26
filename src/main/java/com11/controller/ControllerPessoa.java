package com11.controller;

import com11.DTO.DTOPessoa;
import com11.model.Pessoa;
import com11.service.ServicePessoa;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class ControllerPessoa {
    final ServicePessoa sp ;

    @GetMapping("/pessoas")
    public List<Pessoa> getPessoas(){
        return sp.getPessoas();
    }
    @PostMapping("/pessoas/criar")
    public void criarPessoas(@RequestBody DTOPessoa dtoPessoa){
        sp.createPessoas(dtoPessoa);
    }
    @DeleteMapping("/pessoas/deletar")
    public void deletarPessoas(@RequestBody UUID id){
        sp.deletarPessoas(id);
    }
    @PutMapping("/pessoas/atualizar")
    public void atualizarPessoas(@RequestBody String nomeNovo, UUID id){
        sp.atualizarPessoas(id,nomeNovo);
    }
}