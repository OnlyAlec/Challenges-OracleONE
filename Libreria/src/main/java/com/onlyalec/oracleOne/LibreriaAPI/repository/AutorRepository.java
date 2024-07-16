package com.onlyalec.oracleOne.LibreriaAPI.repository;

import com.onlyalec.oracleOne.LibreriaAPI.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<List<Autor>> findAutorByDeathYearGreaterThanEqual(Integer deathYear);
}
