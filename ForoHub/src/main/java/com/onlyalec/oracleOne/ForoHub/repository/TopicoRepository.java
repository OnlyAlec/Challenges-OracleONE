package com.onlyalec.oracleOne.ForoHub.repository;

import com.onlyalec.oracleOne.ForoHub.domain.topico.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findByStatusTrue(Pageable paginacion);
}
