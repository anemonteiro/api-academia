package com.academia.fortal.api_academia.domain.dto;

import lombok.Data;

@Data
public class TreinoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private Float duracao;
    private Integer nivel;
}
