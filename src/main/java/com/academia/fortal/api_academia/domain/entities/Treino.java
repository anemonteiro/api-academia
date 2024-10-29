package com.academia.fortal.api_academia.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "treino")
@Data
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private Float duracao;

    private Integer nivel;
}
