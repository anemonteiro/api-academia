package com.academia.fortal.api_academia.domain.entities;

import jakarta.persistence.*;

import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Manutencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long equipamentoId;
    private LocalDate data;
    private String descricao;
}
