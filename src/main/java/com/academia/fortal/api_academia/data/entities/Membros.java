package com.academia.fortal.api_academia.data.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "alunos")
@Data
public class Membros {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "plano_aula_id", nullable = false)
    private PlanoDeAulas planoDeAulas;

    //usar YYYY-MM-DD quando for consumir
    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    //usar YYYY-MM-DD quando for consumir
    @Column(name = "data_fim")
    @Temporal(TemporalType.DATE)
    private Date dataFim;
}
