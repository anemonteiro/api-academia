package com.academia.fortal.api_academia.data.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AlunoDTO {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private LocalDate nascimento;
}
