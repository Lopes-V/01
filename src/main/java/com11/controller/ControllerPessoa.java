package com11.controller;
//FEITO ATE AQUI
import com11.DTO.DTOPessoa;
import com11.interfaceService.InterPessoa;
import com11.model.Pessoa;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/pessoa")
public abstract class ControllerPessoa extends InterPessoa {

    // Endpoint para obter todas as pessoas
    @GetMapping()
    public ResponseEntity<List<Pessoa>> pegarPessoas(){
        return ResponseEntity.ok(getPessoas());
    }

    // Endpoint para criar uma nova pessoa
    @PostMapping("/criar")
    public ResponseEntity<?> criarPessoas(@RequestBody DTOPessoa dtoPessoa){
        if(createPessoas(dtoPessoa)){
            return ResponseEntity.ok(Map.of("message", "Pessoa criada com sucesso"));
        } else {
            return ResponseEntity.badRequest().body(Map.of("message", "Erro ao criar pessoa"));
        }
    }

    // Endpoint para deletar uma pessoa
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletePessoas(@PathVariable UUID id){
        if(deletarPessoas(id)){
            return ResponseEntity.ok(Map.of("message", "Pessoa deletada com sucesso"));
        } else {
            return ResponseEntity.badRequest().body(Map.of("message", "Erro ao deletar pessoa"));
        }
    }

    // Endpoint para atualizar o nome de uma pessoa
    @PutMapping("/atualizar")
    public ResponseEntity<?> atualizarPessoas(@RequestBody String nomeNovo, UUID id){
        if(atualizarPessoas(id,nomeNovo)){
            return ResponseEntity.ok(Map.of("message", "Pessoa atualizada com sucesso"));
        } else {
            return ResponseEntity.badRequest().body(Map.of("message", "Erro ao atualizar pessoa"));
        }
    }
}