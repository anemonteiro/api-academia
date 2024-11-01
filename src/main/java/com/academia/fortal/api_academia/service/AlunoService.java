package com.academia.fortal.api_academia.service;

import com.academia.fortal.api_academia.domain.dto.AlunoDTO;
import com.academia.fortal.api_academia.domain.entities.Aluno;
import com.academia.fortal.api_academia.dozer.DozerConverter;
import com.academia.fortal.api_academia.exceptions.CommonsException;
import com.academia.fortal.api_academia.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public AlunoDTO salvar(AlunoDTO aluno){

        var entity = DozerConverter.parseObject(aluno, Aluno.class);
        Aluno entityDTO = alunoRepository.save(entity);
        return DozerConverter.parseObject(entityDTO, AlunoDTO.class);
    }

    public List<AlunoDTO> findAll(){
        return DozerConverter.parseListObjects(alunoRepository.findAll(), AlunoDTO.class);
    }

    public AlunoDTO findById(Long id){
        var entity = alunoRepository.findById(id);
        if(entity.isEmpty()){
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "academia.fortal.aluno.notfound",
                    "O aluno com o ID informado, não foi encontrado");
        }
        return DozerConverter.parseObject(entity.get(), AlunoDTO.class);
    }

    public void delete(Long id){
        if (!alunoRepository.existsById(id)) {
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "academia.fortal.aluno.notfound",
                    "O aluno com o ID informado não foi encontrado");
        }
        alunoRepository.deleteById(id);
    }

}
