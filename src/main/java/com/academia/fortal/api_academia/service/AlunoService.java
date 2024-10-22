package com.academia.fortal.api_academia.service;

import com.academia.fortal.api_academia.data.dto.AlunoDTO;
import com.academia.fortal.api_academia.data.entities.Aluno;
import com.academia.fortal.api_academia.dozer.DozerConverter;
import com.academia.fortal.api_academia.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public AlunoDTO salvar(AlunoDTO aluno){

        //convertendo o AlunoDTO para Aluno
        var entity = DozerConverter.parseObject(aluno, Aluno.class);
        //Recebendo o retorno do save (aluno)
        var entityDTO = alunoRepository.save(entity);
        //Converte e retorna o Aluno em AlunoDTO
        return DozerConverter.parseObject(entityDTO, AlunoDTO.class);
    }

    public List<AlunoDTO> findAll(){
        return DozerConverter.parseListObjects(alunoRepository.findAll(), AlunoDTO.class);
    }

    public AlunoDTO findById(Long id){
        var entity = alunoRepository.findById(id);
        return DozerConverter.parseObject(entity.get(), AlunoDTO.class);
    }

    public void delete(Long id){
        alunoRepository.deleteById(id);
    }

}
