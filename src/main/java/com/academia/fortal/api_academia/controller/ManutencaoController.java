package com.academia.fortal.api_academia.controller;

import com.academia.fortal.api_academia.domain.dto.ManutencaoDTO;
import com.academia.fortal.api_academia.service.ManutencaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-academia/manutencao")
public class ManutencaoController {

    @Autowired
    private ManutencaoService manutencaoService;

    @Operation(summary = "Registrar uma nova manutenção", description = "Registra uma nova manutenção para um equipamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Manutenção registrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Equipamento não encontrado")
    })
    @PostMapping("/{equipamentoId}")
    public ManutencaoDTO registrarManutencao(@PathVariable Long equipamentoId, @RequestBody ManutencaoDTO manutencaoDTO) {
        return manutencaoService.registrarManutencao(equipamentoId, manutencaoDTO);
    }

    @Operation(summary = "Listar manutenções de um equipamento", description = "Lista todas as manutenções realizadas para um equipamento específico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de manutenções retornada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Equipamento não encontrado")
    })
    @GetMapping("/{equipamentoId}")
    public List<ManutencaoDTO> listarManutencao(@PathVariable Long equipamentoId) {
        return manutencaoService.listarManutencaoPorEquipamento(equipamentoId);
    }
}
