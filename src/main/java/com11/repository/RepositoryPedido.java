package com11.repository;

import com11.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface
RepositoryPedido extends JpaRepository<Pedido,Long> {
}
