package com.punto3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //breaking bad
        JSONObject serie1 = new JSONObject();
        serie1.put("id", 1);
        serie1.put("titulo", "Breaking Bad");
        serie1.put("creador", "Vince Gilligan");
        serie1.put("año de lanzamiento", 2008);
        serie1.put("cantidad de temporadas", 5);
        JSONArray episodios1 = new JSONArray();
        episodios1.add(7);
        episodios1.add(13);
        episodios1.add(13);
        episodios1.add(13);
        episodios1.add(16);
        JSONArray actores1 = new JSONArray();
        actores1.add("Bryan Cranston");
        actores1.add("Aaron Paul");
        actores1.add("Anna Gunn");
        JSONArray generos1 = new JSONArray();
        generos1.add("Comedia Oscura");
        generos1.add("Crimen y Drogas");
        generos1.add("Drama Psicologico");
        generos1.add("Suspenso Psicologico");
        generos1.add("Tragedia");
        serie1.put("estado", "finalizada");
        serie1.put("calificación", 9.5);

        //chernobyl
        JSONObject serie2 = new JSONObject();
        serie2.put("id", 2);
        serie2.put("titulo", "Chernobyl");
        serie2.put("creador", "Craig Mazin");
        serie2.put("año de lanzamiento", 2019);
        serie2.put("cantidad de temporadas", 1);
        JSONArray episodios2 = new JSONArray();
        episodios2.add(5);
        JSONArray actores2 = new JSONArray();
        actores2.add("Jared Harros");
        actores2.add("Jessie Buckley");
        actores2.add("Stellan Skarsgard");
        JSONArray generos2 = new JSONArray();
        generos2.add("Desastre");
        generos2.add("Docudrama");
        generos2.add("Drama de Época");
        generos2.add("Drama Psicologico");
        generos2.add("Épica");
        serie2.put("estado", "finalizada");
        serie2.put("calificación", 9.3);

        //the wire
        JSONObject serie3 = new JSONObject();
        serie3.put("id", 3);
        serie3.put("titulo", "The Wire");
        serie3.put("creador", "David Simon");
        serie3.put("año de lanzamiento", 2002);
        serie3.put("cantidad de temporadas", 5);
        JSONArray episodios3 = new JSONArray();
        episodios3.add(13);
        episodios3.add(12);
        episodios3.add(12);
        episodios3.add(13);
        episodios3.add(10);
        JSONArray actores3 = new JSONArray();
        actores3.add("Dominic West");
        actores3.add("Lance Reddick");
        actores3.add("Sonja John");
        JSONArray generos3 = new JSONArray();
        generos3.add("Crimen y Drogas");
        generos3.add("Drama de policia");
        generos3.add("Drama Psicologico");
        serie3.put("estado", "finalizada");
        serie3.put("calificación", 9.3);

    }
}