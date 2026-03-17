package com11.controller;
import com11.DTO.DTOPessoa;
import com11.model.Pessoa;
import com11.service.ServicePessoa;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/pessoa")
public class ControllerPessoa{
    private final ServicePessoa sp;
    // Endpoint para obter todas as pessoas
    @GetMapping()
    public ResponseEntity<List<Pessoa>> pegarPessoas(){
        return ResponseEntity.ok(sp.getPessoas());
    }

    // Endpoint para criar uma nova pessoa
    @PostMapping("/criar")
    public ResponseEntity<?> criarPessoas(@RequestBody DTOPessoa dtoPessoa){
        if(sp.createPessoas(dtoPessoa)){
            return ResponseEntity.ok(Map.of("message", "Pessoa criada com sucesso"));
        } else {
            return ResponseEntity.badRequest().body(Map.of("message", "Erro ao criar pessoa"));
        }
    }

    // Endpoint para deletar uma pessoa
    @DeleteMapping("/deletar/{idPessoa}")
    public ResponseEntity<?> deletePessoas(@PathVariable UUID id){
        if(sp.deletarPessoas(id)){
            return ResponseEntity.ok(Map.of("message", "Pessoa deletada com sucesso"));
        } else {
            return ResponseEntity.badRequest().body(Map.of("message", "Erro ao deletar pessoa"));
        }
    }

    // Endpoint para atualizar o nome de uma pessoa
    @PutMapping("/atualizar")
    public ResponseEntity<?> atualizarPessoas(@RequestBody String nomeNovo, UUID id){
        if(sp.atualizarPessoas(id,nomeNovo)){
            return ResponseEntity.ok(Map.of("message", "Pessoa atualizada com sucesso"));
        } else {
            return ResponseEntity.badRequest().body(Map.of("message", "Erro ao atualizar pessoa"));
        }
    }
}