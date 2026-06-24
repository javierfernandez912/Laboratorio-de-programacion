package com.unpa.gestion_libros.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unpa.gestion_libros.model.Genero;
import com.unpa.gestion_libros.repository.GeneroRepository;

@Service
public class GeneroService implements GeneroServiceInterface {

    @Autowired
    private GeneroRepository generoRepositorio;

    @Override
    public List<Genero> listarGeneros() {
        return generoRepositorio.findAll();  //trae todos los generos. para mostrarlos en el menu de carga de libros.
    }
}