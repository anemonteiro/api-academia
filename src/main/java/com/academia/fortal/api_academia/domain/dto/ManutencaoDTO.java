package com.academia.fortal.api_academia.domain.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ManutencaoDTO {
    private Long id;
    private Long equipamentoId;
    private LocalDate data;
    private String descricao;
}
