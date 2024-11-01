package com.academia.fortal.api_academia.controller;

import com.academia.fortal.api_academia.domain.dto.MembrosDTO;
import com.academia.fortal.api_academia.service.MembrosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-academia/membros")
public class MembrosController {

    @Autowired
    private MembrosService membrosService;

    @Operation(summary = "Cadastrar um novo membro", description = "Cadastra um novo membro na academia")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Membro cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @PostMapping
    public ResponseEntity<MembrosDTO> cadastrar(@RequestBody MembrosDTO membrosDTO) {
        MembrosDTO savedMembro = membrosService.salvar(membrosDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMembro);
    }

    @Operation(summary = "Listar todos os membros", description = "Retorna uma lista de todos os membros cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de membros retornada com sucesso")
    })
    @GetMapping("/todos")
    public List<MembrosDTO> findAll() {
        return membrosService.findAll();
    }

    @Operation(summary = "Buscar um membro por ID", description = "Retorna os detalhes de um membro pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Membro encontrado"),
            @ApiResponse(responseCode = "404", description = "Membro não encontrado")
    })
    @GetMapping("/{id}")
    public MembrosDTO findById(@PathVariable Long id) {
        return membrosService.findById(id);
    }

    @Operation(summary = "Editar um membro", description = "Atualiza os detalhes de um membro existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Membro editado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Membro não encontrado")
    })
    @PutMapping("/edit")
    public MembrosDTO editar(@RequestBody MembrosDTO membrosDTO) {
        return membrosService.salvar(membrosDTO);
    }

    @Operation(summary = "Deletar um membro", description = "Remove um membro da academia pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Membro deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Membro não encontrado")
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        membrosService.delete(id);
    }
}
