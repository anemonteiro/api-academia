package com.academia.fortal.api_academia.controller;

import com.academia.fortal.api_academia.domain.dto.MembrosDTO;
import com.academia.fortal.api_academia.service.MembrosService;
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

    @PostMapping
    public ResponseEntity<MembrosDTO> cadastrar(@RequestBody MembrosDTO membrosDTO) {
        MembrosDTO savedMembro = membrosService.salvar(membrosDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMembro);
    }

    @GetMapping("/todos")
    public List<MembrosDTO> findAll() {
        return membrosService.findAll();
    }

    @GetMapping("/{id}")
    public MembrosDTO findById(@PathVariable Long id) {
        return membrosService.findById(id);
    }

    @PutMapping("/edit")
    public MembrosDTO editar(@RequestBody MembrosDTO membrosDTO) {
        return membrosService.salvar(membrosDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        membrosService.delete(id);
    }
}
