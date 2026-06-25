package com.punto3;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Serie> listaSeries = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static final String FILE_NAME = "series.json";

    public static void main(String[] args) {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("--- GESTIÓN DE SERIES ---");
            System.out.println("1. Crear nueva serie");
            System.out.println("2. Guardar series en JSON");
            System.out.println("3. Cargar series desde archivo");
            System.out.println("4. Mostrar series guardadas");
            System.out.println("5. Listar titulo, año  y temporadas");
            System.out.println("6. Mostrar actores de una serie");
            System.out.println("7. Mostrar series con calificacion mayor a 8");
            System.out.println("8. Mostrar series de un determinado actor");
            System.out.println("0. Salir");
            System.out.println("Ingrese una opcion:");
            opcion = leerEntero();

            switch (opcion) {
                case 1: {
                    crearSerie();
                    break;
                }
                case 2: {
                    guardarArchivo();
                    break;
                }
                case 3: {
                    cargarArchivo();
                    break;
                }
                case 4: {
                    mostrarSeries();
                    break;
                }
                case 5: {
                    listarInformacion();
                    break;
                }
                case 6: {
                    contarActores();
                    break;
                }
                case 7: {
                    filtrarCalificacionAlta();
                    break;
                }
                case 8: {
                    buscarPorActor();
                    break;
                }

                case 0: {
                    System.out.println("Saliendo...");
                    break;
                }
                default: {
                    System.out.println("Opción no válida.");
                    break;
                }
            }
        }
    }

    private static void crearSerie() {
        System.out.println("------ Nueva Serie -------");
        System.out.println("Ingrese el ID de la Serie:");
        int id = leerEntero();
        System.out.print("Titulo: ");
        String titulo = sc.nextLine();
        System.out.print("Creador: ");
        String creador = sc.nextLine();
        System.out.println("Año de lanzamiento:");
        int anio = leerEntero();
        System.out.println("Ingrese la cantidad de temporadas:");
        int temporadas = leerEntero();

        List<Integer> episodios = new ArrayList<>();
        for (int i = 1; i <= temporadas; i++) {
            System.out.println("Ingrese los episodios para la temporada " + i);
            episodios.add(leerEntero());
        }

        System.out.print("Actores principales (separar con coma): ");
        List<String> actores = Arrays.asList(sc.nextLine().split("\\s*,\\s*"));

        System.out.print("Generos (separar con coma): ");
        List<String> generos = Arrays.asList(sc.nextLine().split("\\s*,\\s*"));

        System.out.print("Estado (finalizada/en emisión): ");
        String estado = sc.nextLine();

        System.out.println("Calificación (Numeros con coma. Ej: 8,5)");
        double calificacion = leerDouble();

        listaSeries.add(
                new Serie(id, titulo, creador, anio, temporadas, episodios, actores, generos, estado, calificacion));
        System.out.println("Serie agregada con exito.");
    }

    private static void guardarArchivo() {
        String jsonContent = SerieJSON.convertirListaCompleta(listaSeries);
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            writer.write(jsonContent);
            System.out.println("Archivo '" + FILE_NAME + "' guardado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }

    private static void cargarArchivo() {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(FILE_NAME)) {
            JSONObject root = (JSONObject) parser.parse(reader);
            JSONArray array = (JSONArray) root.get("series");

            System.out.println("Contenido del Archivo JSON: ");
            System.out.println(root.toJSONString());

        } catch (Exception e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static void mostrarSeries() {
        if (listaSeries.isEmpty()) {
            System.out.println("No hay series en memoria.");
        } else {
            for (Serie s : listaSeries) {
                System.out.println("[" + s.getId() + "] " + s.getTitulo() + " - " + s.getCalificacion());
            }
        }
    }

    // validaciones de scanner
    private static int leerEntero() {
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Error. Entero no valido, ");
        }
        int n = sc.nextInt();
        sc.nextLine();
        return n;
    }

    private static double leerDouble() {
        while (!sc.hasNextDouble()) {
            sc.next();
            System.out.print("Error. Calificacion no valida.");
        }
        double d = sc.nextDouble();
        sc.nextLine();
        return d;
    }

    // a) Listar información. Mostrar: título, año y cantidad de temporadas de todas las series.
    private static void listarInformacion() {
        System.out.println("Total de series: ");
        if (listaSeries.isEmpty()) {
            System.out.println("No hay datos cargados.");
            return;
        }
        for (Serie s : listaSeries) {
            System.out.println("Título: " + s.getTitulo() + ". | Año: " + s.getAnioLanzamiento()
                    + ". | Cantidad de temporadas: " + s.getCantidadTemporadas());
        }
    }

    // b) Contar información. Mostrar cada serie junto con la cantidad de actores principales.
    private static void contarActores() {
        System.out.println("Cantidad de actores por serie:");
        for (Serie s : listaSeries) {
            int cantidad = s.getActoresPrincipales().size();
            System.out.println("Serie: " + s.getTitulo() + " | Actores Principales: " + cantidad);
        }
    }

    //c) Filtrar información. Mostrar las series cuya calificación sea mayor a 8.
    private static void filtrarCalificacionAlta() {
        System.out.println("Series con calificacion mayor a 8:");
        boolean enc = false;
        for (Serie s : listaSeries) {
            if (s.getCalificacion() > 8.0) {
                System.out.println("- " + s.getTitulo() + " (Calificacion: " + s.getCalificacion() + ")");
                enc = true;
            }
        }
        if (!enc) {
            System.out.println("No hay series con calificacion superior a 8.");
        }
    }

    //d) Búsqueda avanzada. Mostrar las series donde participe un actor específico (ingresado por teclado).

    private static void buscarPorActor() {
        System.out.print("Ingrese el nombre del actor a buscar: ");
        String nombreBuscado = sc.nextLine().trim();

        System.out.println("Series donde aparece '" + nombreBuscado + "':");
        for (Serie s : listaSeries) {
            for (String actor : s.getActoresPrincipales()) {
                if (actor.equalsIgnoreCase(nombreBuscado)) {
                    System.out.println(s.getTitulo() + " (" + s.getAnioLanzamiento() + ")");
                    return;
                }
            }
        }
        System.out.println("No se encontraron series con ese actor.");
    }
}