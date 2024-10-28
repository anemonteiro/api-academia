package com.academia.fortal.api_academia.data.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "alunos")
@Data
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
