package com.onlyalec.oracleOne.ForoHub.controllers;


import com.onlyalec.oracleOne.ForoHub.domain.curso.RespuestaCursoDTO;
import com.onlyalec.oracleOne.ForoHub.domain.topico.RegistroTopicoDTO;
import com.onlyalec.oracleOne.ForoHub.domain.topico.RespuestaTopicoDTO;
import com.onlyalec.oracleOne.ForoHub.domain.topico.Topico;
import com.onlyalec.oracleOne.ForoHub.domain.usuario.RespuestaUsuarioDTO;
import com.onlyalec.oracleOne.ForoHub.repository.CursoRepository;
import com.onlyalec.oracleOne.ForoHub.repository.TopicoRepository;
import com.onlyalec.oracleOne.ForoHub.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    //Registro de un nuevo topico
    @PostMapping
    public ResponseEntity<RespuestaTopicoDTO> registrarTopico(@RequestBody @Valid RegistroTopicoDTO data, UriComponentsBuilder uriComponentsBuilder) {
        Topico topico = topicoRepository.save(new Topico(data, usuarioRepository, cursoRepository));
        RespuestaTopicoDTO res = new RespuestaTopicoDTO(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.isStatus(),
                new RespuestaUsuarioDTO(topico.getAutor().getId(), topico.getAutor().getNombre()),
                new RespuestaCursoDTO(topico.getCurso().getId(), topico.getCurso().getNombre(), topico.getCurso().getCategoria()));
        URI url = uriComponentsBuilder.path("/topico/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(res);
    }

    //Mostrar todos los topicos
    @GetMapping
    public ResponseEntity<Page<RespuestaTopicoDTO>> obtenerTopicos(@PageableDefault(size = 5) Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findByStatusTrue(paginacion).map(RespuestaTopicoDTO::new));
    }

    //Detallando un topico
    @GetMapping("/{id}")
    public ResponseEntity<RespuestaTopicoDTO> obtenerDetalleTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        RespuestaTopicoDTO res = new RespuestaTopicoDTO(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.isStatus(),
                new RespuestaUsuarioDTO(topico.getAutor().getId(), topico.getAutor().getNombre()),
                new RespuestaCursoDTO(topico.getCurso().getId(), topico.getCurso().getNombre(), topico.getCurso().getCategoria()));
        return ResponseEntity.ok(res);
    }

    // Actualizar Topico
    @PostMapping("/{id}")
    public ResponseEntity<RespuestaTopicoDTO> actualizaTopico(@PathVariable Long id, @RequestBody @Valid RegistroTopicoDTO data) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.actualiza(data, usuarioRepository, cursoRepository);
        RespuestaTopicoDTO res = new RespuestaTopicoDTO(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.isStatus(),
                new RespuestaUsuarioDTO(topico.getAutor().getId(), topico.getAutor().getNombre()),
                new RespuestaCursoDTO(topico.getCurso().getId(), topico.getCurso().getNombre(), topico.getCurso().getCategoria()));
        return ResponseEntity.ok(res);
    }

    // Eliminar Topico
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.eliminarTopico();
        return ResponseEntity.noContent().build();
    }

}
