package com.academia.fortal.api_academia.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "alunos")
@Data
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    private String telefone;

    @Temporal(TemporalType.DATE)
    //formato da data: yyyy-mm-dd
    private LocalDate nascimento;
}
