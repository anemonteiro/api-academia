package com.academia.fortal.api_academia.repository;

import com.academia.fortal.api_academia.data.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AlunoRepository extends JpaRepository <Aluno, Long> {


}
