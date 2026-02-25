package com11.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_pessoa")
    private UUID id;
    @Column(name = "nome_pessoa")
    private String nome;

    public Pessoa(String nome) {
    }
}
