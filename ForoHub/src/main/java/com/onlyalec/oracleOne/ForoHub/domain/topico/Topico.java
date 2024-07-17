package com.onlyalec.oracleOne.ForoHub.domain.topico;

import com.onlyalec.oracleOne.ForoHub.domain.curso.Curso;
import com.onlyalec.oracleOne.ForoHub.domain.respuesta.Respuesta;
import com.onlyalec.oracleOne.ForoHub.domain.usuario.Usuario;
import com.onlyalec.oracleOne.ForoHub.repository.CursoRepository;
import com.onlyalec.oracleOne.ForoHub.repository.UsuarioRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Table(name = "Topicos")
@Entity(name = "topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    @Column(unique = true)
    private String mensaje;

    private Date fechaCreacion;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "idAutor")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "idCurso")
    private Curso curso;

    @OneToMany(mappedBy = "topico")
    private List<Respuesta> respuestas;

    public Topico(RegistroTopicoDTO data, UsuarioRepository usuarioRepository, CursoRepository cursoRepository) {
        this.titulo = data.titulo();
        this.mensaje = data.mensaje();
        this.fechaCreacion = new Date();
        this.status = true;
        this.autor = getUsuarioById(data.autor(), usuarioRepository);
        this.curso = getCursoByName(data.curso(), cursoRepository);
        this.respuestas = null;
    }

    private Usuario getUsuarioById(String idStr, UsuarioRepository usrRepo) {
        Long id = Long.valueOf(idStr);
        Optional<Usuario> usr = usrRepo.findById(id);
        return usr.orElse(null);

    }

    private Curso getCursoByName(String nombreCurso, CursoRepository curRepo) {
        Optional<Curso> cur = curRepo.findByNombre(nombreCurso);
        return cur.orElse(null);

    }

    public void actualiza(RegistroTopicoDTO data, UsuarioRepository usrRepo, CursoRepository cursoRepository) {
        this.titulo = data.titulo();
        this.mensaje = data.mensaje();
        this.autor = getUsuarioById(data.autor(), usrRepo);
        this.curso = getCursoByName(data.curso(), cursoRepository);
    }

    public void eliminarTopico() {
        this.status = false;
    }
}
