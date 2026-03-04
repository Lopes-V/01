package com11.repository;

import com11.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryUsuario extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByName(String name);
    Optional<Usuario> findByEmail(String email);
}
