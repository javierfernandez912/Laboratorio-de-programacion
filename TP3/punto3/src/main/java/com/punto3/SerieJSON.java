package com.punto3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.List;

public class SerieJSON {

    //pasa de serie a json
    public static JSONObject toJSON(Serie serie) {
        JSONObject obj = new JSONObject();

        obj.put("id", serie.getId());
        obj.put("titulo", serie.getTitulo());
        obj.put("creador", serie.getCreador());
        obj.put("año de lanzamiento", serie.getAnioLanzamiento());
        obj.put("cantidad de temporadas", serie.getCantidadTemporadas());

        //pasa las listas a array de json
        JSONArray listaEpisodios = new JSONArray();
        listaEpisodios.addAll(serie.getEpisodios());
        obj.put("episodios", listaEpisodios);

        JSONArray listaActores = new JSONArray();
        listaActores.addAll(serie.getActoresPrincipales());
        obj.put("actores principales", listaActores);

        JSONArray listaGeneros = new JSONArray();
        listaGeneros.addAll(serie.getGeneros());
        obj.put("generos", listaGeneros);

        obj.put("estado", serie.getEstado());
        obj.put("calificación", serie.getCalificacion());

        return obj;
    }

    
     // Convierte un array de series a json
    public static String convertirListaCompleta(List<Serie> series) {
        JSONObject root = new JSONObject();
        JSONArray arraySeries = new JSONArray();

        for (Serie serie : series) {
            arraySeries.add(toJSON(serie));
        }

        root.put("series", arraySeries);
        return root.toJSONString();
    }
}
