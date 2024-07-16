package com.onlyalec.oracleOne.LibreriaAPI.repository;

import com.onlyalec.oracleOne.LibreriaAPI.model.Idioma;
import com.onlyalec.oracleOne.LibreriaAPI.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface LibroRepostory extends JpaRepository<Libro, Long> {
    Optional<List<Libro>> findByLanguages(Idioma languages);
}
