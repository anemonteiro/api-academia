package com.academia.fortal.api_academia.service;

import com.academia.fortal.api_academia.domain.dto.MembrosDTO;
import com.academia.fortal.api_academia.domain.entities.Aluno;
import com.academia.fortal.api_academia.domain.entities.Membros;
import com.academia.fortal.api_academia.domain.entities.PlanoDeAula;
import com.academia.fortal.api_academia.dozer.DozerConverter;
import com.academia.fortal.api_academia.exceptions.CommonsException;
import com.academia.fortal.api_academia.repository.AlunoRepository;
import com.academia.fortal.api_academia.repository.MembrosRepository;
import com.academia.fortal.api_academia.repository.PlanoDeAulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MembrosService {

    @Autowired
    private MembrosRepository membrosRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private PlanoDeAulaRepository planoDeAulaRepository;

    public MembrosDTO salvar(MembrosDTO membrosDTO) {
        Aluno aluno = alunoRepository.findById(membrosDTO.getAlunoId()).orElse(null);
        PlanoDeAula planoDeAula = planoDeAulaRepository.findById(membrosDTO.getPlanoDeAulaId()).orElse(null);

        Membros membro = new Membros();
        membro.setAluno(aluno);
        membro.setPlanoDeAula(planoDeAula);
        membro.setDataInicio(membrosDTO.getDataInicio());
        membro.setDataFim(membrosDTO.getDataFim());

        Membros savedMembros = membrosRepository.save(membro);

        membrosDTO.setId(savedMembros.getId());
        membrosDTO.setAlunoId(savedMembros.getAluno() != null ? savedMembros.getAluno().getId() : null);
        membrosDTO.setPlanoDeAulaId(savedMembros.getPlanoDeAula() != null ? savedMembros.getPlanoDeAula().getId() : null);

        return membrosDTO;
    }

    public List<MembrosDTO> findAll() {
        List<Membros> membrosList = membrosRepository.findAll();
        List<MembrosDTO> membrosDTOList = new ArrayList<>();

        for (Membros membro : membrosList) {
            MembrosDTO dto = DozerConverter.parseObject(membro, MembrosDTO.class);
            dto.setAlunoId(membro.getAluno() != null ? membro.getAluno().getId() : null);
            dto.setPlanoDeAulaId(membro.getPlanoDeAula() != null ? membro.getPlanoDeAula().getId() : null);
            membrosDTOList.add(dto);
        }

        return membrosDTOList;
    }

    public MembrosDTO findById(Long id) {
        Membros membros = membrosRepository.findById(id).orElse(null);
        return DozerConverter.parseObject(membros, MembrosDTO.class);
    }

    public void delete(Long id) {
        if (!membrosRepository.existsById(id)) {
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "academia.fortal.membro.notfound",
                    "O aluno com o ID informado não foi encontrado, portanto não é membro");
        }
        membrosRepository.deleteById(id);
    }
}
