package com.unpa.gestion_libros.model;

import jakarta.persistence.*;

@Entity
@Table(name = "LIBROSDIG")
public class LibroDigital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lib")
    private Integer id; // primary key numerico de 5 digitos

    @Column(name = "TITULO", length = 50, nullable = false)
    private String titulo; // texto de maximo 50 caracteres

    @Column(name = "AUTOR", length = 30, nullable = false)
    private String autor; // texto max 30

    @Column(name = "EDITORIAL", length = 30, nullable = false)
    private String editorial; // texto max 30

    @Column(name = "ANIO_EDICION", nullable = false)
    private Integer anioEdicion; // año edicion maximo 4 digitos

    @ManyToOne
    @JoinColumn(name = "genero_id", nullable = false) //foreign key
    private Genero genero;

    public LibroDigital() {
    }

    // setters y getters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Integer getAnioEdicion() {
        return anioEdicion;
    }

    public void setAnioEdicion(Integer anioEdicion) {
        this.anioEdicion = anioEdicion;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}