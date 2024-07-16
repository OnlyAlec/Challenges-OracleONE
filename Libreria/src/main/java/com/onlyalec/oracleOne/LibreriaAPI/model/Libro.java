package com.onlyalec.oracleOne.LibreriaAPI.model;

import jakarta.persistence.*;


@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Autor authors;

    @Enumerated(EnumType.STRING)
    private Idioma languages;

    private Integer downloadCount;

    public Libro() {
    }

    public Libro(DTOLibro dataLibro) {
        this.title = dataLibro.title();
        this.authors = dataLibro.authors().stream().map(Autor::new).findFirst().orElse(null);
        this.languages = dataLibro.languages().stream().map(Idioma::fromString).findFirst().orElse(null);
        this.downloadCount = dataLibro.downloadCount();

    }

    @Override
    public String toString() {
        return "----------------------------------------------------\n" +
                "Titulo:" + this.title + "\nAutores:" + this.authors
                + "\nIdioma:" + this.languages + "\nCantidad Descargas:" + this.downloadCount
                + "\n----------------------------------------------------";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Autor getAuthors() {
        return authors;
    }

    public void setAuthors(Autor authors) {
        this.authors = authors;
    }

    public Idioma getLanguages() {
        return languages;
    }

    public void setLanguages(Idioma languages) {
        this.languages = languages;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }
}
