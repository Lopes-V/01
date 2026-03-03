package com11.controller;

import com11.DTO.DTOLoginRequest;
import com11.repository.RepositoryUsuario;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/auth")
public class ControllerLogin {

    private RepositoryUsuario usuarioRepository;
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody DTOLoginRequest loginRequest) {
        var usuario = usuarioRepository.findByEmail(loginRequest.getEmail());

        if (usuario.isEmpty()) {
            return ResponseEntity.badRequest().body("Usuário não encontrado");
        }

        if (!passwordEncoder.matches(loginRequest.getSenha(), usuario.get().getSenha())) {
            return ResponseEntity.badRequest().body("Senha incorreta");
        }

        return ResponseEntity.ok().body("Login realizado com sucesso");
    }
}
