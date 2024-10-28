package com.academia.fortal.api_academia.service;

import com.academia.fortal.api_academia.data.dto.MembrosDTO;
import com.academia.fortal.api_academia.data.entities.Membros;
import com.academia.fortal.api_academia.dozer.DozerConverter;
import com.academia.fortal.api_academia.repository.MembrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembrosService {

    @Autowired
    private MembrosRepository membrosRepository;

    public MembrosDTO salvar(MembrosDTO membros){

        var entity = DozerConverter.parseObject(membros, Membros.class);
        Membros entityDTO = membrosRepository.save(entity);
        return DozerConverter.parseObject(entityDTO, MembrosDTO.class);
    }

    public List<MembrosDTO> findAll(){
        return DozerConverter.parseListObjects(membrosRepository.findAll(), MembrosDTO.class);
    }

    public MembrosDTO findById(Long id){
        var entity = membrosRepository.findById(id);
        return DozerConverter.parseObject(entity.get(), MembrosDTO.class);
    }

    public void delete(Long id){
        membrosRepository.deleteById(id);
    }

}
