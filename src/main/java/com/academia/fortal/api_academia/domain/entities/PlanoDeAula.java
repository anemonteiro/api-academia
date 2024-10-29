package com.academia.fortal.api_academia.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "plano_de_aula")
@Data
public class PlanoDeAula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private Float duracao;

    @OneToMany(mappedBy = "planoDeAula")
    private List<Membros> membros;
}
