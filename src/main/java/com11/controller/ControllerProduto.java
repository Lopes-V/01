package com11.controller;

import com11.DTO.DTOProduto;
import com11.model.Produto;
import com11.service.ServiceProduto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ControllerProduto {

    ServiceProduto sp;

    @GetMapping("/produto")
    public List<Produto> getProduto() {
        return sp.getProduto();
    }

    @PostMapping("/produto/criar")
    public void criarProduto(@RequestBody DTOProduto dtoProduto) {
        sp.createProduto(dtoProduto);
    }

    @DeleteMapping("/produto/deletar/{id}")
    public void deletarProduto(@PathVariable Long id) {
        sp.deletarPessoas(id);
    }

    @PutMapping("/produto/atualizar")
    public void atualizarProduto(@RequestBody String nomeNovo, Long id) {
        sp.atualizarPessoas(id,nomeNovo);
    }
}