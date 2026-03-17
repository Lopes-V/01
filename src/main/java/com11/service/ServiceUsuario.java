package com11.service;

import com11.model.Usuario;
import com11.repository.RepositoryUsuario;
import lombok.extern.log4j.Log4j2;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public interface ServiceUsuario extends RepositoryUsuario {
    // Método para criar um novo usuário, garantindo que a senha seja criptografada
    default boolean createUsuario(Usuario usuario) {
        usuario.setSenha(passwordEncoder().encode(usuario.getSenha()));
        try{
            save(usuario);
            return true;
        }catch (RuntimeException e){

            return false;
        }
    }

    default List<Usuario> getUsuario() {
        try{
            return findAll();
        }catch (RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }
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
        Usuario user = findByEmail(usuario.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return passwordEncoder().matches(usuario.getSenha(), user.getSenha());
    }

    // Método para deletar um usuário pelo ID
    default boolean deletarUsuario(Long id) {
        try{
            deleteById(id);
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

     Optional<Usuario> findByEmail(String email);
    // Método para obter um usuário pelo email
     default PasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder();
     }
}
