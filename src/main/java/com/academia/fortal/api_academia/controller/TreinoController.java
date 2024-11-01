package com.academia.fortal.api_academia.controller;

import com.academia.fortal.api_academia.domain.dto.TreinoDTO;
import com.academia.fortal.api_academia.service.TreinoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-academia/treino")
public class TreinoController {

    @Autowired
    private TreinoService treinoService;

    @Operation(summary = "Cadastrar um novo treino", description = "Cadastra um novo treino na academia")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Treino cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @PostMapping
    public TreinoDTO cadastrar(@RequestBody TreinoDTO treino) {
        return treinoService.salvar(treino);
    }

    @Operation(summary = "Listar todos os treinos", description = "Retorna uma lista de todos os treinos cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de treinos retornada com sucesso")
    })
    @GetMapping("/todos")
    public List<TreinoDTO> findAll() {
        return treinoService.findAll();
    }

    @Operation(summary = "Buscar um treino por ID", description = "Retorna os detalhes de um treino pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Treino encontrado"),
            @ApiResponse(responseCode = "404", description = "Treino não encontrado")
    })
    @GetMapping("/{id}")
    public TreinoDTO findById(@PathVariable Long id) {
        return treinoService.findById(id);
    }

    @Operation(summary = "Editar um treino", description = "Atualiza os detalhes de um treino existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Treino editado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Treino não encontrado")
    })
    @PutMapping("/edit")
    public TreinoDTO editar(@RequestBody TreinoDTO treino) {
        return treinoService.salvar(treino);
    }

    @Operation(summary = "Deletar um treino", description = "Remove um treino da academia pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Treino deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Treino não encontrado")
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        treinoService.delete(id);
    }
}
