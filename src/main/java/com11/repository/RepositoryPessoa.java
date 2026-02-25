package com11.repository;

import com11.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositoryPessoa extends JpaRepository<Pessoa, UUID> {
}
