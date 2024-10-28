package com.academia.fortal.api_academia.service;

import com.academia.fortal.api_academia.data.dto.PlanoDeAulaDTO;
import com.academia.fortal.api_academia.data.entities.PlanoDeAula;
import com.academia.fortal.api_academia.dozer.DozerConverter;
import com.academia.fortal.api_academia.repository.PlanoDeAulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoDeAulaService {

    @Autowired
    private PlanoDeAulaRepository planoDeAulaRepository;

    public PlanoDeAulaDTO salvar(PlanoDeAulaDTO planoDeAula){

        var entity = DozerConverter.parseObject(planoDeAula, PlanoDeAula.class);
        PlanoDeAula entityDTO = planoDeAulaRepository.save(entity);
        return DozerConverter.parseObject(entityDTO, PlanoDeAulaDTO.class);
    }

    public List<PlanoDeAulaDTO> findAll(){
        return DozerConverter.parseListObjects(planoDeAulaRepository.findAll(), PlanoDeAulaDTO.class);
    }

    public PlanoDeAulaDTO findById(Long id){
        var entity = planoDeAulaRepository.findById(id);
        return DozerConverter.parseObject(entity.get(), PlanoDeAulaDTO.class);
    }

    public void delete(Long id){
        planoDeAulaRepository.deleteById(id);
    }

}
