package com.tp1.gestionlibrosdigitales;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "LIBROSDIG")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 50)
    private String titulo;

    @Column(nullable = false, length = 30)
    private String autor;

    @Column(nullable = false, length = 30)
    private String editorial;

    @Column(name = "Año_edicion", nullable = false, columnDefinition = "INT(4)")
    private int anio_edicion;
}
