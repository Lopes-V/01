package com11.controller;

import com11.DTO.DTOLoginRequest;
import com11.model.Usuario;
import com11.service.ServiceUsuario;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class ControllerLogin {
    private final ServiceUsuario usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody DTOLoginRequest loginRequest) {
        // Cria o objeto para validar
        Usuario usuarioParaValidar = Usuario.builder()
                .email(loginRequest.email())
                .senha(loginRequest.senha())
                .build();

        // Usa o serviço injetado em vez de um método herdado
        if(usuarioService.identificarUsuario(usuarioParaValidar)) {
            return ResponseEntity.ok().body(Map.of("mensagem", "Login realizado com sucesso"));
        }

        return ResponseEntity.status(401).body(Map.of("mensagem", "Credenciais inválidas"));
    }
}