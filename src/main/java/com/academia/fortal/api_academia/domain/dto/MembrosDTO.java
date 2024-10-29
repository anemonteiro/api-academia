package com.academia.fortal.api_academia.domain.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MembrosDTO {
    private Long id;
    private Long alunoId;
    private Long planoDeAulaId;
    private LocalDate dataInicio;
    private LocalDate dataFim;
}
