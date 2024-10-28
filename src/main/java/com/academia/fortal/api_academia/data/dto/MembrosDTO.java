package com.academia.fortal.api_academia.data.dto;

import com.academia.fortal.api_academia.data.entities.Aluno;
import com.academia.fortal.api_academia.data.entities.PlanoDeAula;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MembrosDTO {
    private Long id;
    private Aluno aluno;
    private PlanoDeAula planoDeAula;
    private LocalDate dataInicio;
    private LocalDate dataFim;
}
