package com11.service;

import com11.model.Usuario;
import com11.repository.RepositoryUsuario;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioDetailsService extends RepositoryUsuario{

    // Implementação do método loadUserByUsername para autenticação
    default UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Usuario usuario = findByName(name)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        return User.builder()
                .username(usuario.getName())
                .password(usuario.getSenha())
                .roles(usuario.getRole())
                .build();
    }
}
