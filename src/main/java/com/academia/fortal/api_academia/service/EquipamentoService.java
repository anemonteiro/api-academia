package com.academia.fortal.api_academia.service;

import com.academia.fortal.api_academia.domain.dto.EquipamentoDTO;
import com.academia.fortal.api_academia.domain.entities.Equipamento;
import com.academia.fortal.api_academia.dozer.DozerConverter;
import com.academia.fortal.api_academia.repository.EquipamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    public EquipamentoDTO salvar(EquipamentoDTO equipamento){

        var entity = DozerConverter.parseObject(equipamento, Equipamento.class);
        Equipamento entityDTO = equipamentoRepository.save(entity);
        return DozerConverter.parseObject(entityDTO, EquipamentoDTO.class);
    }

    public List<EquipamentoDTO> findAll(){
        return DozerConverter.parseListObjects(equipamentoRepository.findAll(), EquipamentoDTO.class);
    }

    public EquipamentoDTO findById(Long id){
        var entity = equipamentoRepository.findById(id);
        return DozerConverter.parseObject(entity.get(), EquipamentoDTO.class);
    }

    public void delete(Long id){
        equipamentoRepository.deleteById(id);
    }

    public EquipamentoDTO atualizarStatus(Long id, String status) {
        var entity = equipamentoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Equipamento não encontrado"));

        entity.setStatus(status);
        Equipamento updatedEntity = equipamentoRepository.save(entity);
        return DozerConverter.parseObject(updatedEntity, EquipamentoDTO.class);
    }

}
