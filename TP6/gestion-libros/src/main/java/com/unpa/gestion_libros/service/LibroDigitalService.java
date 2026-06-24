package com.unpa.gestion_libros.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unpa.gestion_libros.model.LibroDigital;
import com.unpa.gestion_libros.repository.LibroDigitalRepository;

@Service
public class LibroDigitalService implements LibroDigitalServiceInterface {

    @Autowired
    private LibroDigitalRepository repositorio;

    @Override
    public List<LibroDigital> listar() {
        return repositorio.findAll(); // trae todos los libros
    }

    @Override
    public LibroDigital guardarLibro(LibroDigital libro) {
        return repositorio.save(libro); // guarda el libro. tambien sirve para editarlos.
    }

    @Override
    public LibroDigital obtenerLibroPorId(Integer id) {
        return repositorio.findById(id).orElse(null); //trae un libro segun el id
    }

    @Override
    public void eliminarLibro(Integer id) {
        repositorio.deleteById(id); //elimina el libro segun el id
    }
}