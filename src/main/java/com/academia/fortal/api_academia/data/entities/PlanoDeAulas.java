package com.academia.fortal.api_academia.data.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "planoDeAulas")
@Data
public class PlanoDeAulas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id-PlanoAulas")
    private Long id;

    @Column(name = "nome-PlanoAula")
    public String name;

    @Column(name = "descricao-PlanoAula")
    public String description;

    @Column(name = "duracao-PlanoAula")
    public String lenght;

    @ManyToMany
    @Column(name = "membros-PlanoAula")
    public Membros membros;
}
