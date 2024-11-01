package com.academia.fortal.api_academia.repository;

import com.academia.fortal.api_academia.domain.entities.Manutencao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {
    List<Manutencao> findByEquipamentoId(Long equipamentoId);
}
