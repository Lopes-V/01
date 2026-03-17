package com11.controller;

import com11.DTO.DTOUsuario;
import com11.model.Usuario;
import com11.service.ServiceUsuario;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class ControllerUsuario{
    private final ServiceUsuario sp;

    @PostMapping("/criar")
    // Endpoint para criar um novo usuário
    public ResponseEntity<?> criarUsuario(@RequestBody Usuario usuario){
        if(sp.createUsuario(usuario)) {
            return ResponseEntity.ok().body("Usuário criado com sucesso");
        } else {
            return ResponseEntity.badRequest().body("Erro ao criar usuário");
        }
    }

    @GetMapping()
    // Endpoint para pegar o usuário logado
    public ResponseEntity<?> pegarUsuario(){
        if (sp.getUsuario()!= null){
            return ResponseEntity.ok(sp.getUsuario());
        }else {
            return ResponseEntity.badRequest().body("Erro ao pegar usuário");
        }
    }

    @DeleteMapping("/deletar/{id}")
    // Endpoint para deletar um usuário por ID
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id){
        if(sp.deletarUsuario(id)){
            return ResponseEntity.ok().body("Usuário deletado com sucesso");
        } else {
            return ResponseEntity.badRequest().body("Erro ao deletar usuário");
        }
    }
}
