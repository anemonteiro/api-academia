package com.academia.fortal.api_academia.data.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "equipamento")
@Data
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome_equipamento", nullable = false)
    private String name;

    private String marca;

    @Column(nullable = false)
    private String status;

    private Integer quantidade;
}
