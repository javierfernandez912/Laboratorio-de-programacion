package com.punto5;

public class LibroDig {
    private int id;
    private String titulo;
    private String autor;
    private String editorial;
    private int anioEdicion;
    private int generoId; // foreign key
    private double precio; // Se agrega para generar alguna estadistica como promedio, max, min.

    public LibroDig(int id, String titulo, String autor, String editorial, int anioEdicion, int generoId,
            double precio) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.anioEdicion = anioEdicion;
        this.generoId = generoId;
        this.precio = precio;
    }

    
    public int getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public double getPrecio() {
        return this.precio;
    }

    public int getGeneroId() {
        return this.generoId;
    }

    public String getAutor(){
        return this.autor;
    }

    public int getAnioEdicion(){
        return this.anioEdicion;
    }

    public String getEditorial(){
        return this.editorial;
    }


    public void setTitulo(String t) {
        this.titulo = t;
    }

    public void setPrecio(double p) {
        this.precio = p;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + ". Titulo: " + this.titulo + ". Autor: " + this.autor + ". Editorial: " + this.editorial + ". Año de edicion: " + this.anioEdicion + ". Precio: " + this.precio + ". ID Genero: " + this.generoId + ".";
    }
}