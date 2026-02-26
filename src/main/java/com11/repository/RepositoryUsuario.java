package com11.repository;

import com11.model.Usuario;
import org.aspectj.lang.reflect.UnlockSignature;
import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryUsuario extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByUserName(String userName);
}
