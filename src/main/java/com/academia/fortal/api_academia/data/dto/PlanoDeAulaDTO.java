package com.academia.fortal.api_academia.data.dto;

import com.academia.fortal.api_academia.data.entities.Membros;
import lombok.Data;

import java.util.List;

@Data
public class PlanoDeAulaDTO {
    private Long id;
    private String nome;
    private String descricao;
    private Float duracao;
    private List<Membros> membros;

}
