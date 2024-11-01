package com.academia.fortal.api_academia.controller;

import com.academia.fortal.api_academia.domain.dto.EquipamentoDTO;
import com.academia.fortal.api_academia.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-academia/equipamento")
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;

    @PostMapping
    public EquipamentoDTO cadastrar(@RequestBody EquipamentoDTO equipamento){
        return equipamentoService.salvar(equipamento);
    }

    @GetMapping("/todos")
    public List<EquipamentoDTO> findAll(){
        return equipamentoService.findAll();
    }

    @GetMapping("/{id}")
    public EquipamentoDTO findById(@PathVariable Long id){return equipamentoService.findById(id);}

    @PutMapping("/edit")
    public EquipamentoDTO editar(@RequestBody EquipamentoDTO equipamento){
        return equipamentoService.salvar(equipamento);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        equipamentoService.delete(id);
    }

    @PatchMapping("/{id}/status")
    public EquipamentoDTO atualizarStatus(@PathVariable Long id, @RequestBody String status) {
        return equipamentoService.atualizarStatus(id, status);
    }
}
