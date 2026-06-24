package com.unpa.gestion_libros.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "GENEROS")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genero_id")
    private Integer id; // pk maximo 5 digitos

    @Column(name = "NOMBRE", length = 20, nullable = false)
    private String nombre; // texto maximo 20 caracteres

    @OneToMany(mappedBy = "genero", cascade = CascadeType.ALL)
    private List<LibroDigital> libros;

    public Genero() {
    }

    // setters y getters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<LibroDigital> getLibros() {
        return libros;
    }

    public void setLibros(List<LibroDigital> libros) {
        this.libros = libros;
    }
}