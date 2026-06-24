package com.unpa.gestion_libros.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.unpa.gestion_libros.model.LibroDigital;
import com.unpa.gestion_libros.service.LibroDigitalService;
import com.unpa.gestion_libros.service.GeneroService;

@Controller
@RequestMapping("/libros")
public class LibroDigitalController {

    // inyeccion de servicios
    @Autowired
    private LibroDigitalService libroService;

    @Autowired
    private GeneroService generoService;

    // pantalla de todos los libros
    @GetMapping
    public String listarLibros(Model modelo) {
        List<LibroDigital> lista = libroService.listar();
        modelo.addAttribute("libros", lista);
        return "ListaLibros";
    }

    // muestra el formulario para dar de alta un libro
    @GetMapping("/nuevo")
    public String formularioNuevoLibro(Model modelo) {
        LibroDigital nuevoLibro = new LibroDigital();
        modelo.addAttribute("libro", nuevoLibro);
        modelo.addAttribute("generos", generoService.listarGeneros()); // 
        return "GestionLibros";
    }

    // guarda el registro
    @PostMapping("/guardar")
    public String guardarLibro(@ModelAttribute("libro") LibroDigital libro) {
        libroService.guardarLibro(libro);
        return "redirect:/libros";
    }

    // muestra formulario de edicion de libro (mismo que de carga pero te manda al id a editar)
    @GetMapping("/editar/{id}")
    public String formularioEditarLibro(@PathVariable Integer id, Model modelo) {
        modelo.addAttribute("libro", libroService.obtenerLibroPorId(id));
        modelo.addAttribute("generos", generoService.listarGeneros());
        return "GestionLibros";
    }

    // elimina un libro
    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable Integer id) {
        libroService.eliminarLibro(id);
        return "redirect:/libros";
    }

    // escucha la raiz y redirige al index
    @GetMapping("/")
    public String landingPage() {
        return "Index";
    }
}