package com.academia.fortal.api_academia.controller;

import com.academia.fortal.api_academia.data.dto.PlanoDeAulaDTO;
import com.academia.fortal.api_academia.service.PlanoDeAulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-academia/planodeaula")
public class PlanoDeAulaController {

    @Autowired
    private PlanoDeAulaService planoDeAulaService;

    @PostMapping
    public PlanoDeAulaDTO cadastrar(@RequestBody PlanoDeAulaDTO planoDeAula){
        return planoDeAulaService.salvar(planoDeAula);
    }

    @GetMapping("/todos")
    public List<PlanoDeAulaDTO> findAll(){
        return planoDeAulaService.findAll();
    }

    @PutMapping
    public PlanoDeAulaDTO editar(@RequestBody PlanoDeAulaDTO planoDeAula){
        return planoDeAulaService.salvar(planoDeAula);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        planoDeAulaService.delete(id);
    }
}
