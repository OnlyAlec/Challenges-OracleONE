package com.onlyalec.oracleOne.ForoHub.repository;

import com.onlyalec.oracleOne.ForoHub.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByNombre(String nombre);
}
