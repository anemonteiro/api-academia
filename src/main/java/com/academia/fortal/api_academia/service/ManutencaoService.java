package com.academia.fortal.api_academia.service;

import com.academia.fortal.api_academia.domain.dto.ManutencaoDTO;
import com.academia.fortal.api_academia.domain.entities.Manutencao;
import com.academia.fortal.api_academia.dozer.DozerConverter;
import com.academia.fortal.api_academia.repository.ManutencaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManutencaoService {

    @Autowired
    private ManutencaoRepository manutencaoRepository;

    public ManutencaoDTO registrarManutencao(Long equipamentoId, ManutencaoDTO manutencaoDTO) {
        Manutencao manutencao = new Manutencao();
        manutencao.setEquipamentoId(equipamentoId);
        manutencao.setData(manutencaoDTO.getData());
        manutencao.setDescricao(manutencaoDTO.getDescricao());
        Manutencao savedManutencao = manutencaoRepository.save(manutencao);
        return DozerConverter.parseObject(savedManutencao, ManutencaoDTO.class);
    }

    public List<ManutencaoDTO> listarManutencaoPorEquipamento(Long equipamentoId) {
        List<Manutencao> manutencoes = manutencaoRepository.findByEquipamentoId(equipamentoId);
        return DozerConverter.parseListObjects(manutencoes, ManutencaoDTO.class);
    }
}
