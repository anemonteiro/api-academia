package com.academia.fortal.api_academia.domain.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "equipamento")
@Data
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_equipamento", nullable = false)
    private String nome;

    private String marca;

    @Column(nullable = false)
    private String status;

    private Integer quantidade;
}
