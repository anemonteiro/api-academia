package com.academia.fortal.api_academia.service;

import com.academia.fortal.api_academia.domain.dto.PlanoDeAulaDTO;
import com.academia.fortal.api_academia.domain.entities.PlanoDeAula;
import com.academia.fortal.api_academia.dozer.DozerConverter;
import com.academia.fortal.api_academia.exceptions.CommonsException;
import com.academia.fortal.api_academia.repository.PlanoDeAulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoDeAulaService {

    @Autowired
    private PlanoDeAulaRepository planoDeAulaRepository;

    public PlanoDeAulaDTO salvar(PlanoDeAulaDTO planoDeAula){
        var entity = DozerConverter.parseObject(planoDeAula, PlanoDeAula.class);
        PlanoDeAula savedPlanoDeAula = planoDeAulaRepository.save(entity);
        return DozerConverter.parseObject(savedPlanoDeAula, PlanoDeAulaDTO.class);
    }

    public List<PlanoDeAulaDTO> findAll(){
        return DozerConverter.parseListObjects(planoDeAulaRepository.findAll(), PlanoDeAulaDTO.class);
    }

    public PlanoDeAulaDTO findById(Long id){
        var entity = planoDeAulaRepository.findById(id);
        if(entity.isEmpty()){
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "academia.fortal.planodeaula.notfound",
                    "O Plano de Aula com o ID informado, não foi encontrado");
        }
        return DozerConverter.parseObject(entity.get(), PlanoDeAulaDTO.class);
    }

    public void delete(Long id){
        if (!planoDeAulaRepository.existsById(id)) {
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "academia.fortal.planodeaula.notfound",
                    "O Plano de Aula com o ID informado não foi encontrado");
        }
        planoDeAulaRepository.deleteById(id);
    }
}
