package com11.controller;

import com11.DTO.DTOLoginRequest;
import com11.interfaceService.InterUsuario;
import com11.model.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public abstract class ControllerLogin extends InterUsuario {
    // Endpoint para login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody DTOLoginRequest loginRequest) {
        if(identificarUsuario(Usuario.builder().email(loginRequest.email()).senha(loginRequest.senha()).build())) {
            return ResponseEntity.ok().body(Map.of("mensagem", "Login realizado com sucesso"));
        }
        return ResponseEntity.status(401).body(Map.of("mensagem", "Credenciais inválidas"));
    }
}