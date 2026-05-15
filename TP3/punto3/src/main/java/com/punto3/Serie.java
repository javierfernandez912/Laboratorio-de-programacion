package com.punto3;

import java.util.List;

public class Serie {
    private int id;
    private String titulo;
    private String creador;
    private int anioLanzamiento;
    private int cantidadTemporadas;
    private List<Integer> episodios;
    private List<String> actoresPrincipales;
    private List<String> generos;
    private String estado;
    private double calificacion;

    public Serie(int id, String titulo, String creador, int anioLanzamiento,
            int cantidadTemporadas, List<Integer> episodios,
            List<String> actoresPrincipales, List<String> generos,
            String estado, double calificacion) {
        this.id = id;
        this.titulo = titulo;
        this.creador = creador;
        this.anioLanzamiento = anioLanzamiento;
        this.cantidadTemporadas = cantidadTemporadas;
        this.episodios = episodios;
        this.actoresPrincipales = actoresPrincipales;
        this.generos = generos;
        this.estado = estado;
        this.calificacion = calificacion;
    }

    public int getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getCreador() {
        return this.creador;
    }

    public int getAnioLanzamiento() {
        return this.anioLanzamiento;
    }

    public int getCantidadTemporadas() {
        return this.cantidadTemporadas;
    }

    public List<Integer> getEpisodios() {
        return this.episodios;
    }

    public List<String> getActoresPrincipales() {
        return this.actoresPrincipales;
    }

    public List<String> getGeneros() {
        return this.generos;
    }

    public String getEstado() {
        return this.estado;
    }

    public double getCalificacion() {
        return this.calificacion;
    }

}