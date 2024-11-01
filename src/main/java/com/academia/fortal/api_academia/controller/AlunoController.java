package com.academia.fortal.api_academia.controller;

import com.academia.fortal.api_academia.domain.dto.AlunoDTO;
import com.academia.fortal.api_academia.service.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-academia/aluno")
@Tag(name = "Aluno", description = "Gerenciamento de Alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    @Operation(summary = "Cadastrar Aluno", description = "Registra um novo aluno no sistema.")
    public AlunoDTO cadastrar(@RequestBody AlunoDTO aluno) {
        return alunoService.salvar(aluno);
    }

    @GetMapping("/todos")
    @Operation(summary = "Listar Alunos", description = "Lista todos os alunos cadastrados.")
    public List<AlunoDTO> findAll() {
        return alunoService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Aluno por ID", description = "Retorna os dados de um aluno pelo seu ID.")
    public AlunoDTO findById(@PathVariable Long id) {
        return alunoService.findById(id);
    }

    @PutMapping("/edit")
    @Operation(summary = "Editar Aluno", description = "Edita os dados de um aluno já existente.")
    public AlunoDTO editar(@RequestBody AlunoDTO aluno) {
        return alunoService.salvar(aluno);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar Aluno", description = "Remove um aluno do sistema pelo seu ID.")
    public void delete(@PathVariable Long id) {
        alunoService.delete(id);
    }
}
