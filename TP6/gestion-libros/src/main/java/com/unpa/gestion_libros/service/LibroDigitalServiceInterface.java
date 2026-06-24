package com.unpa.gestion_libros.service;

import java.util.List;
import com.unpa.gestion_libros.model.LibroDigital;

public interface LibroDigitalServiceInterface {
    public List<LibroDigital> listar();
    public LibroDigital guardarLibro(LibroDigital libro);
    public LibroDigital obtenerLibroPorId(Integer id);
    public void eliminarLibro(Integer id);
}