package com.academia.fortal.api_academia.service;

import com.academia.fortal.api_academia.domain.dto.MembrosDTO;
import com.academia.fortal.api_academia.domain.entities.Aluno;
import com.academia.fortal.api_academia.domain.entities.Membros;
import com.academia.fortal.api_academia.domain.entities.PlanoDeAula;
import com.academia.fortal.api_academia.dozer.DozerConverter;
import com.academia.fortal.api_academia.repository.AlunoRepository;
import com.academia.fortal.api_academia.repository.MembrosRepository;
import com.academia.fortal.api_academia.repository.PlanoDeAulaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        Membros membros = DozerConverter.parseObject(membrosDTO, Membros.class);
        membros.setAluno(alunoRepository.findById(membrosDTO.getAlunoId()).orElse(null));
        membros.setPlanoDeAula(planoDeAulaRepository.findById(membrosDTO.getPlanoDeAulaId()).orElse(null));

        Membros savedMembros = membrosRepository.save(membros);
        return DozerConverter.parseObject(savedMembros, MembrosDTO.class);
    }

    public MembrosDTO matricularAluno(Long alunoId, Long planoAulaId, LocalDate dataInicio, LocalDate dataFim) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));
        PlanoDeAula planoAula = planoDeAulaRepository.findById(planoAulaId)
                .orElseThrow(() -> new EntityNotFoundException("Plano de aula não encontrado"));

        Membros membros = new Membros();
        membros.setAluno(aluno);
        membros.setPlanoDeAula(planoAula);
        membros.setDataInicio(dataInicio);
        membros.setDataFim(dataFim);

        Membros savedMembros = membrosRepository.save(membros);
        return DozerConverter.parseObject(savedMembros, MembrosDTO.class);
    }

    public List<MembrosDTO> findAll() {
        return DozerConverter.parseListObjects(membrosRepository.findAll(), MembrosDTO.class);
    }

    public MembrosDTO findById(Long id) {
        Membros membros = membrosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Membros não encontrado"));
        return DozerConverter.parseObject(membros, MembrosDTO.class);
    }

    public void delete(Long id) {
        membrosRepository.deleteById(id);
    }
}
