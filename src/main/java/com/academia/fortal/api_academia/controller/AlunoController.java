package com.academia.fortal.api_academia.controller;

import com.academia.fortal.api_academia.domain.dto.AlunoDTO;
import com.academia.fortal.api_academia.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-academia/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public AlunoDTO cadastrar(@RequestBody AlunoDTO aluno){
        return alunoService.salvar(aluno);
    }

    @GetMapping("/todos")
    public List<AlunoDTO> findAll(){
        return alunoService.findAll();
    }

    @GetMapping("/{id}")
    public AlunoDTO findById(@PathVariable Long id){return alunoService.findById(id);}

    @PutMapping("/edit")
    public AlunoDTO editar(@RequestBody AlunoDTO aluno){
        return alunoService.salvar(aluno);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        alunoService.delete(id);
    }
}
