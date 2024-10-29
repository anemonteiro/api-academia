package com.academia.fortal.api_academia.data.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "membros")
@Data
public class Membros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "plano_aula_id", nullable = false)
    private PlanoDeAula planoDeAula;

    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    private LocalDate dataInicio;

    @Column(name = "data_fim")
    @Temporal(TemporalType.DATE)
    private LocalDate dataFim;
}
