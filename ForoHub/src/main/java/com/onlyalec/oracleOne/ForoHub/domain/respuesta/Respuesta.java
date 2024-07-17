package com.onlyalec.oracleOne.ForoHub.domain.respuesta;

import com.onlyalec.oracleOne.ForoHub.domain.topico.Topico;
import com.onlyalec.oracleOne.ForoHub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "Respuestas")
@Entity(name = "respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;

    @ManyToOne
    @JoinColumn(name = "idTopico")
    private Topico topico;
    private Date fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "idAutor")
    private Usuario autor;
    private boolean solucion;
}
