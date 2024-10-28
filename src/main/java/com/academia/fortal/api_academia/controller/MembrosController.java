package com.academia.fortal.api_academia.controller;

import com.academia.fortal.api_academia.data.dto.MembrosDTO;
import com.academia.fortal.api_academia.service.MembrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-academia/membros")
public class MembrosController {

    @Autowired
    private MembrosService membrosService;

    @PostMapping
    public MembrosDTO cadastrar(@RequestBody MembrosDTO membros){
        return membrosService.salvar(membros);
    }

    @GetMapping("/todos")
    public List<MembrosDTO> findAll(){
        return membrosService.findAll();
    }

    @GetMapping("/{id}")
    public MembrosDTO findById(@PathVariable Long id){return membrosService.findById(id);}

    @PutMapping("/edit")
    public MembrosDTO editar(@RequestBody MembrosDTO membros){
        return membrosService.salvar(membros);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        membrosService.delete(id);
    }
}
