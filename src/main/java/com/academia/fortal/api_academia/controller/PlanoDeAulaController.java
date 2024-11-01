package com.academia.fortal.api_academia.controller;

import com.academia.fortal.api_academia.domain.dto.PlanoDeAulaDTO;
import com.academia.fortal.api_academia.service.PlanoDeAulaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-academia/planodeaula")
public class PlanoDeAulaController {

    @Autowired
    private PlanoDeAulaService planoDeAulaService;

    @Operation(summary = "Cadastrar um novo plano de aula", description = "Cadastra um novo plano de aula na academia")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Plano de aula cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @PostMapping
    public PlanoDeAulaDTO cadastrar(@RequestBody PlanoDeAulaDTO planoDeAula) {
        return planoDeAulaService.salvar(planoDeAula);
    }

    @Operation(summary = "Listar todos os planos de aula", description = "Retorna uma lista de todos os planos de aula cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de planos de aula retornada com sucesso")
    })
    @GetMapping("/todos")
    public List<PlanoDeAulaDTO> findAll() {
        return planoDeAulaService.findAll();
    }

    @Operation(summary = "Buscar um plano de aula por ID", description = "Retorna os detalhes de um plano de aula pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Plano de aula encontrado"),
            @ApiResponse(responseCode = "404", description = "Plano de aula não encontrado")
    })
    @GetMapping("/{id}")
    public PlanoDeAulaDTO findById(@PathVariable Long id) {
        return planoDeAulaService.findById(id);
    }

    @Operation(summary = "Editar um plano de aula", description = "Atualiza os detalhes de um plano de aula existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Plano de aula editado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Plano de aula não encontrado")
    })
    @PutMapping("/edit")
    public PlanoDeAulaDTO editar(@RequestBody PlanoDeAulaDTO planoDeAula) {
        return planoDeAulaService.salvar(planoDeAula);
    }

    @Operation(summary = "Deletar um plano de aula", description = "Remove um plano de aula da academia pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Plano de aula deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Plano de aula não encontrado")
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        planoDeAulaService.delete(id);
    }
}
