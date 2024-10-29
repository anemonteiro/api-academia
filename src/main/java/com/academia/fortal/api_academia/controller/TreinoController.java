package com.academia.fortal.api_academia.controller;

import com.academia.fortal.api_academia.domain.dto.TreinoDTO;
import com.academia.fortal.api_academia.service.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-academia/treino")
public class TreinoController {

    @Autowired
    private TreinoService treinoService;

    @PostMapping
    public TreinoDTO cadastrar(@RequestBody TreinoDTO treino){
        return treinoService.salvar(treino);
    }

    @GetMapping("/todos")
    public List<TreinoDTO> findAll(){
        return treinoService.findAll();
    }

    @GetMapping("/{id}")
    public TreinoDTO findById(@PathVariable Long id){return treinoService.findById(id);}

    @PutMapping("/edit")
    public TreinoDTO editar(@RequestBody TreinoDTO treino){
        return treinoService.salvar(treino);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        treinoService.delete(id);
    }
}
