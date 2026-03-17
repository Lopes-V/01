package com11.controller;
import com11.DTO.DTOProduto;
import com11.model.Produto;
import com11.service.ServiceProduto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/produto")
public class ControllerProduto {
    private final ServiceProduto sp;

    // Endpoint para obter a lista de produtos
    @GetMapping()
    public ResponseEntity<List<Produto>> pegarProduto() {
        return ResponseEntity.ok(sp.getProduto());
    }

    // Endpoint para criar um novo produto
    @PostMapping("/criar")
    public ResponseEntity<?> criarProduto(@RequestBody DTOProduto dtoProduto) {
        if(sp.createProduto(dtoProduto)){
            return ResponseEntity.ok().body("Produto criado com sucesso");
        } else {
            return ResponseEntity.badRequest().body("Erro ao criar produto");
        }
    }

    // Endpoint para deletar um produto por ID
    @DeleteMapping("/deletar/{idProduto}")
    public ResponseEntity<?> deletarProduto(@PathVariable Long id) {
        if(sp.deletarPessoas(id)){
            return ResponseEntity.ok().body("Produto deletado com sucesso");
        } else {
            return ResponseEntity.badRequest().body("Erro ao deletar produto");
        }
    }

    // Endpoint para atualizar o nome de um produto por ID
    @PutMapping("/atualizar")
    public ResponseEntity<?> atualizarProduto(@RequestBody String nomeNovo, Long id) {
        if(sp.atualizarPessoas(id,nomeNovo)){
            return ResponseEntity.ok().body("Produto atualizado com sucesso");
        } else {
            return ResponseEntity.badRequest().body("Erro ao atualizar produto");
        }
    }
}