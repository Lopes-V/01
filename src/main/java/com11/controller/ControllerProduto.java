package com11.controller;
//FEITO ATE AQUI
import com11.DTO.DTOProduto;
import com11.interfaceService.InterProduto;
import com11.model.Produto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/produto")
public abstract class ControllerProduto extends InterProduto{

    // Endpoint para obter a lista de produtos
    @GetMapping()
    public ResponseEntity<List<Produto>> pegarProduto() {
        return ResponseEntity.ok(getProduto());
    }

    // Endpoint para criar um novo produto
    @PostMapping("/criar")
    public ResponseEntity<?> criarProduto(@RequestBody DTOProduto dtoProduto) {
        if(createProduto(dtoProduto)){
            return ResponseEntity.ok().body("Produto criado com sucesso");
        } else {
            return ResponseEntity.badRequest().body("Erro ao criar produto");
        }
    }

    // Endpoint para deletar um produto por ID
    @DeleteMapping("/deletar")
    public ResponseEntity<?> deletarProduto(@RequestBody Long id) {
        if(deletarPessoas(id)){
            return ResponseEntity.ok().body("Produto deletado com sucesso");
        } else {
            return ResponseEntity.badRequest().body("Erro ao deletar produto");
        }
    }

    // Endpoint para atualizar o nome de um produto por ID
    @PutMapping("/atualizar")
    public ResponseEntity<?> atualizarProduto(@RequestBody String nomeNovo, Long id) {
        if(atualizarPessoas(id,nomeNovo)){
            return ResponseEntity.ok().body("Produto atualizado com sucesso");
        } else {
            return ResponseEntity.badRequest().body("Erro ao atualizar produto");
        }
    }
}