package com.onlyalec.oracleOne.LibreriaAPI.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;
    private Integer birthYear;
    private Integer deathYear;

    @OneToMany(mappedBy = "authors")
    private List<Libro> book;

    public Autor() {
    }

    public Autor(DTOAutor a) {
        this.name = a.name();
        this.birthYear = a.birthYear();
        this.deathYear = a.deathYear();
    }


    @Override
    public String toString() {
        return "Autor: " + this.name + "(" + this.birthYear + " - " + this.deathYear + ")";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public List<Libro> getBook() {
        return book;
    }

    public void setBook(List<Libro> book) {
        this.book = book;
    }
}