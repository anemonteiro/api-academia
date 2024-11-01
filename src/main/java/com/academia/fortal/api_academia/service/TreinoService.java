package com.academia.fortal.api_academia.service;

import com.academia.fortal.api_academia.domain.dto.TreinoDTO;
import com.academia.fortal.api_academia.domain.entities.Treino;
import com.academia.fortal.api_academia.dozer.DozerConverter;
import com.academia.fortal.api_academia.exceptions.CommonsException;
import com.academia.fortal.api_academia.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreinoService {

    @Autowired
    private TreinoRepository treinoRepository;

    public TreinoDTO salvar(TreinoDTO treino){

        var entity = DozerConverter.parseObject(treino, Treino.class);
        Treino entityDTO = treinoRepository.save(entity);
        return DozerConverter.parseObject(entityDTO, TreinoDTO.class);
    }

    public List<TreinoDTO> findAll(){
        return DozerConverter.parseListObjects(treinoRepository.findAll(), TreinoDTO.class);
    }

    public TreinoDTO findById(Long id){
        var entity = treinoRepository.findById(id);
        if(entity.isEmpty()){
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "academia.fortal.treino.notfound",
                    "O Treino com o ID informado, não foi encontrado");
        }
        return DozerConverter.parseObject(entity.get(), TreinoDTO.class);
    }

    public void delete(Long id){
        if (!treinoRepository.existsById(id)) {
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "academia.fortal.aluno.notfound",
                    "O Treino com o ID informado não foi encontrado");
        }
        treinoRepository.deleteById(id);
    }

}
