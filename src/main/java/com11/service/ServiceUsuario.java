package com11.service;

import com11.model.Usuario;
import com11.repository.RepositoryUsuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ServiceUsuario extends RepositoryUsuario {

    // Método para salvar um usuário, garantindo que a senha seja criptografada
    default boolean salvarUsuario(Usuario usuario) {
        try{
            usuario.setSenha(passwordEncoder().encode(usuario.getSenha()));
            save(usuario);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    // Método para identificar um usuário, verificando se o email e a senha correspondem
    default boolean identificarUsuario(Usuario usuario) {
        Optional<Usuario> user = findByEmail(usuario.getEmail());
        if (!passwordEncoder().matches(usuario.getSenha(), user.map(Usuario::getSenha).orElse(""))) {
            return false;
        }
        return true;
    }
    // Método para obter um usuário pelo email
     default PasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder();
     }
}
