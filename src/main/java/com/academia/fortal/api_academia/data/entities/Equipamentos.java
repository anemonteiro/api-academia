package com.academia.fortal.api_academia.data.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Columns;

@Entity
@Table(name = "equipamentos")
@Data
public class Equipamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nomeEquipamento")
    public String name;
    public String marca;

    @Column(nullable = false)
    public String status;
    public int quantidade;

}
