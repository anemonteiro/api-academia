package com.academia.fortal.api_academia.service;

import com.academia.fortal.api_academia.data.dto.EquipamentoDTO;
import com.academia.fortal.api_academia.data.entities.Equipamento;
import com.academia.fortal.api_academia.dozer.DozerConverter;
import com.academia.fortal.api_academia.repository.EquipamentoRepository;
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

}
