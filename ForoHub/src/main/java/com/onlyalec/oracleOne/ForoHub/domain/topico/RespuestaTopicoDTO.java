package com.onlyalec.oracleOne.ForoHub.domain.topico;

import com.onlyalec.oracleOne.ForoHub.domain.curso.RespuestaCursoDTO;
import com.onlyalec.oracleOne.ForoHub.domain.usuario.RespuestaUsuarioDTO;

import java.util.Date;

public record RespuestaTopicoDTO(
        Long id,
        String titulo,
        String mensaje,
        Date fechaCreacion,
        boolean status,
        RespuestaUsuarioDTO autor,
        RespuestaCursoDTO curso
) {
    public RespuestaTopicoDTO(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.isStatus(), new RespuestaUsuarioDTO(topico.getAutor().getId(), topico.getAutor().getNombre()), new RespuestaCursoDTO(topico.getCurso().getId(), topico.getCurso().getNombre(), topico.getCurso().getCategoria()));
    }
}
