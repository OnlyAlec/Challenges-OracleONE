package com.onlyalec.oracleOne.ForoHub.repository;

import com.onlyalec.oracleOne.ForoHub.domain.curso.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Optional<Curso> findByNombre(String nombreCurso);
}
