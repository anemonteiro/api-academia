package com.academia.fortal.api_academia.data.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "treinos")
@Data
public class Treinos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id-Treino")
    private Long id;

    @Column(name = "nome-Treino")
    public String name;
    public String description;

    @Column(name = "duracao-Treino")
    public float lenght;

    @Column(name = "nivel-Treino")
    public int level;


}
