package com.academia.fortal.api_academia.repository;

import com.academia.fortal.api_academia.data.entities.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentoRepository extends JpaRepository <Equipamento, Long> {


}
