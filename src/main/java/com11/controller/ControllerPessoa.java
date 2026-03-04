package com11.controller;

import com11.DTO.DTOPessoa;
import com11.interfaceService.InterPessoa;
import com11.model.Pessoa;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/pessoa")
public abstract class ControllerPessoa extends InterPessoa {

    // Endpoint para obter todas as pessoas
    @GetMapping()
    public List<Pessoa> getPessoas(){
        return getPessoas();
    }

    // Endpoint para criar uma nova pessoa
    @PostMapping("/criar")
    public void criarPessoas(@RequestBody DTOPessoa dtoPessoa){
        createPessoas(dtoPessoa);
    }

    // Endpoint para deletar uma pessoa
    @DeleteMapping("/deletar/{id}")
    public void deletarPessoas(@PathVariable UUID id){
        deletarPessoas(id);
    }

    // Endpoint para atualizar o nome de uma pessoa
    @PutMapping("/atualizar")
    public void atualizarPessoas(@RequestBody String nomeNovo, UUID id){
        atualizarPessoas(id,nomeNovo);
    }
}