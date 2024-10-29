package com.academia.fortal.api_academia.repository;

import com.academia.fortal.api_academia.domain.entities.Treino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinoRepository extends JpaRepository <Treino, Long> {


}
