package com.academia.fortal.api_academia.repository;

import com.academia.fortal.api_academia.domain.entities.PlanoDeAula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoDeAulaRepository extends JpaRepository <PlanoDeAula, Long> {


}
