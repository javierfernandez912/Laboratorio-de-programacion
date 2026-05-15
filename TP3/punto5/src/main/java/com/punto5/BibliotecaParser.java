package com.punto5;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.*;
import java.util.List;

public class BibliotecaParser {
    private static final String FILE_NAME = "librosdig.json";

    // a, b, f) crear json, guardar archivo y guardar cambios
    public static void guardarDatos(List<LibroDig> libros, List<Genero> generos) {
        JSONObject root = new JSONObject();

        JSONArray jsonGeneros = new JSONArray();
        for (int i = 0; i < generos.size(); i++) {
            Genero g = generos.get(i);
            JSONObject obj = new JSONObject();
            obj.put("id", g.getId());
            obj.put("nombre", g.getNombre());
            jsonGeneros.add(obj);
        }

        JSONArray jsonLibros = new JSONArray();
        for (int i = 0; i < libros.size(); i++) {
            LibroDig l = libros.get(i);
            JSONObject obj = new JSONObject();
            obj.put("id", l.getId());
            obj.put("titulo", l.getTitulo());
            obj.put("autor", l.getAutor());
            obj.put("editorial", l.getEditorial());
            obj.put("anio", l.getAnioEdicion());
            obj.put("genero_id", l.getGeneroId());
            obj.put("precio", l.getPrecio());
            jsonLibros.add(obj);
        }

        root.put("generos", jsonGeneros);
        root.put("libros", jsonLibros);

        try {
            FileWriter writer = new FileWriter(FILE_NAME);
            writer.write(root.toJSONString());
            writer.close();
            System.out.println("Datos guardados exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar archivo: " + e.getMessage());
        }
    }

    // d) Leer y parsear JSON
    public static void cargarDatos(List<LibroDig> libros, List<Genero> generos) {
        JSONParser parser = new JSONParser();
        try {
            FileReader reader = new FileReader(FILE_NAME);
            JSONObject root = (JSONObject) parser.parse(reader);

            JSONArray jsonGeneros = (JSONArray) root.get("generos");
            for (Object o : jsonGeneros) {
                JSONObject j = (JSONObject) o;
                generos.add(new Genero(((Long) j.get("id")).intValue(), (String) j.get("nombre")));
            }

            JSONArray jsonLibros = (JSONArray) root.get("libros");
            for (Object o : jsonLibros) {
                JSONObject j = (JSONObject) o;
                libros.add(new LibroDig(
                        ((Long) j.get("id")).intValue(), (String) j.get("titulo"),
                        (String) j.get("autor"), (String) j.get("editorial"),
                        ((Long) j.get("anio")).intValue(), ((Long) j.get("genero_id")).intValue(),
                        (Double) j.get("precio")));
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("No se encontró archivo previo. Iniciando vacío.");
        }
    }
}
