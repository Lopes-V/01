package com11.controller;

import com11.model.Usuario;
import com11.service.ServiceUsuario;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "localhost:5173", allowedHeaders = "*")
@AllArgsConstructor
public abstract class ControllerUsuario{
    private final ServiceUsuario sp;

    // Endpoint para criar um novo usuário
    public ResponseEntity criarUsuario(Usuario usuario){
        if(sp.createUsuario(usuario)) {
            return ResponseEntity.ok().body("Usuário criado com sucesso");
        } else {
            return ResponseEntity.badRequest().body("Erro ao criar usuário");
        }
    }

    // Endpoint para pegar o usuário logado
    public ResponseEntity pegarUsuario(){
        if (sp.getUsuario()!= null){
            return ResponseEntity.ok(sp.getUsuario());
        }else {
            return ResponseEntity.badRequest().body("Erro ao pegar usuário");
        }
    }

    // Endpoint para deletar um usuário por ID
    public ResponseEntity deletarUsuario(Long id){
        if(sp.deletarUsuario(id)){
            return ResponseEntity.ok().body("Usuário deletado com sucesso");
        } else {
            return ResponseEntity.badRequest().body("Erro ao deletar usuário");
        }
    }
}
