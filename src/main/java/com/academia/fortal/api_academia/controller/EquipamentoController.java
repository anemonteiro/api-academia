package com.academia.fortal.api_academia.controller;

import com.academia.fortal.api_academia.domain.dto.EquipamentoDTO;
import com.academia.fortal.api_academia.service.EquipamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-academia/equipamento")
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;

    @Operation(summary = "Cadastrar um novo equipamento", description = "Cadastra um novo equipamento na academia")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Equipamento cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @PostMapping
    public EquipamentoDTO cadastrar(@RequestBody EquipamentoDTO equipamento) {
        return equipamentoService.salvar(equipamento);
    }

    @Operation(summary = "Listar todos os equipamentos", description = "Retorna uma lista de todos os equipamentos cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de equipamentos retornada com sucesso")
    })
    @GetMapping("/todos")
    public List<EquipamentoDTO> findAll() {
        return equipamentoService.findAll();
    }

    @Operation(summary = "Buscar um equipamento por ID", description = "Retorna os detalhes de um equipamento pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Equipamento encontrado"),
            @ApiResponse(responseCode = "404", description = "Equipamento não encontrado")
    })
    @GetMapping("/{id}")
    public EquipamentoDTO findById(@PathVariable Long id) {
        return equipamentoService.findById(id);
    }

    @Operation(summary = "Editar um equipamento", description = "Atualiza os detalhes de um equipamento existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Equipamento editado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Equipamento não encontrado")
    })
    @PutMapping("/edit")
    public EquipamentoDTO editar(@RequestBody EquipamentoDTO equipamento) {
        return equipamentoService.salvar(equipamento);
    }

    @Operation(summary = "Deletar um equipamento", description = "Remove um equipamento da academia pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Equipamento deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Equipamento não encontrado")
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        equipamentoService.delete(id);
    }

    @Operation(summary = "Atualizar status de um equipamento", description = "Atualiza o status de um equipamento existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Status do equipamento atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Equipamento não encontrado")
    })
    @PatchMapping("/{id}/status")
    public EquipamentoDTO atualizarStatus(@PathVariable Long id, @RequestBody String status) {
        return equipamentoService.atualizarStatus(id, status);
    }
}
