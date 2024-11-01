package com.academia.fortal.api_academia.controller;

import com.academia.fortal.api_academia.domain.dto.ManutencaoDTO;
import com.academia.fortal.api_academia.domain.entities.Manutencao;
import com.academia.fortal.api_academia.service.ManutencaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-academia/manutencao")
public class ManutencaoController {

    @Autowired
    private ManutencaoService manutencaoService;

    @PostMapping("/{equipamentoId}")
    public ManutencaoDTO registrarManutencao(@PathVariable Long equipamentoId, @RequestBody ManutencaoDTO manutencaoDTO) {
        return manutencaoService.registrarManutencao(equipamentoId, manutencaoDTO);
    }

    @GetMapping("/{equipamentoId}")
    public List<ManutencaoDTO> listarManutencao(@PathVariable Long equipamentoId) {
        return manutencaoService.listarManutencaoPorEquipamento(equipamentoId);
    }
}
