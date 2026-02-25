package com11.controller;

import com11.DTO.DTOPessoa;
import com11.model.Pessoa;
import com11.service.ServicePessoa;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
