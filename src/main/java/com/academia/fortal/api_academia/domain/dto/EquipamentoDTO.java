package com.academia.fortal.api_academia.domain.dto;

import lombok.Data;

@Data
public class EquipamentoDTO {
    private Long id;
    private String nome;
    private String marca;
    private String status;
    private Integer quantidade;
}
