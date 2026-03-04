package com11.controller;

import com11.DTO.DTOProduto;
import com11.interfaceService.InterProduto;
import com11.model.Produto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/produto")
public abstract class ControllerProduto extends InterProduto{

    // Endpoint para obter a lista de produtos
    @GetMapping()
    public List<Produto> getProduto() {
        return getProduto();
    }

    // Endpoint para criar um novo produto
    @PostMapping("/criar")
    public void criarProduto(@RequestBody DTOProduto dtoProduto) {
        createProduto(dtoProduto);
    }

    // Endpoint para deletar um produto por ID
    @DeleteMapping("/deletar/{id}")
    public void deletarProduto(@PathVariable Long id) {
        deletarPessoas(id);
    }

    // Endpoint para atualizar o nome de um produto por ID
    @PutMapping("/atualizar")
    public void atualizarProduto(@RequestBody String nomeNovo, Long id) {
        atualizarPessoas(id,nomeNovo);
    }
}