package com.punto5;

import java.util.*;

public class Main {
    private static List<LibroDig> listaLibros = new ArrayList<>();
    private static List<Genero> listaGeneros = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        BibliotecaParser.cargarDatos(listaLibros, listaGeneros);
        if (listaGeneros.isEmpty()) {
            inicializarGeneros(); // Carga inicial por defecto
        }
        int opcion = 0;
        do {
            System.out.println("--- GESTIÓN DE LIBROS DIGITALES ---");
            System.out.println("1. Alta libro\t2. Listar libros\t3. Modificar precio o eliminar");
            System.out.println("4. Busqueda\t5. Consultar estadisticas de libros.\t0. Guardar y salir");
            System.out.println("Ingrese una opcion:");
            opcion = leerEntero();

            switch (opcion) {
                case 1: {
                    altaLibro();
                    break;
                }
                case 2: {
                    for (int i = 0; i < listaLibros.size(); i++) {
                        System.out.println(listaLibros.get(i).toString());
                    }
                    break;
                }
                case 3: {
                    menuEdicion();
                    break;
                }
                case 4: {
                    buscarLibro();
                    break;
                }
                case 5: {
                    generarEstadisticas();
                    break;
                }
                case 0: {
                    BibliotecaParser.guardarDatos(listaLibros, listaGeneros);
                    System.out.println("Saliendo...");
                    break;
                }
                default: {
                    System.out.println("Opción no válida.");
                    break;
                }
            }
        } while (opcion != 0);
    }

    // e) agregar libro
    private static void altaLibro() {
        System.out.println("Generos disponibles: " + listaGeneros);
        System.out.println("ID: ");
        int id = leerEntero();
        System.out.print("Título: ");
        String t = sc.nextLine();
        System.out.print("Autor: ");
        String a = sc.nextLine();
        System.out.print("Editorial: ");
        String ed = sc.nextLine();
        System.out.println("Año Edición: ");
        int anio = leerEntero();
        System.out.println("ID Género: ");
        int gen = leerEntero();
        System.out.println("Precio: ");
        double pre = leerDouble();
        listaLibros.add(new LibroDig(id, t, a, ed, anio, gen, pre));
    }

    // e) Modificar datos (actualizar, eliminar).
    private static void menuEdicion() {
        System.out.print("Ingrese ID del libro a buscar: ");
        int idBuscado = Integer.parseInt(sc.nextLine());
        LibroDig encontrado = null;

        int i = 0;
        while (i < listaLibros.size() && encontrado == null) {
            if (listaLibros.get(i).getId() == idBuscado) {
                encontrado = listaLibros.get(i);
            }
            i++;
        }

        if (encontrado != null) {
            System.out.println("1. Cambiar Precio | 2. Eliminar Libro");
            int sub = Integer.parseInt(sc.nextLine());
            if (sub == 1) {
                System.out.print("Nuevo precio: ");
                encontrado.setPrecio(Double.parseDouble(sc.nextLine()));
            } else if (sub == 2) {
                listaLibros.remove(encontrado);
                System.out.println("Libro eliminado.");
            }
        } else {
            System.out.println("No existe un libro con ese ID.");
        }
    }

    // g) Realizar consultas (filtros - búsquedas - ordenamiento).
    private static void buscarLibro() {
        System.out.print("Texto a buscar en título: ");
        String texto = sc.nextLine().toLowerCase();
        boolean enc = false;
        int i = 0;
        LibroDig libro = null;
        while (i < listaLibros.size() && !enc) {
            libro = listaLibros.get(i);
            if (libro.getTitulo().toLowerCase().contains(texto)) {
                enc = true;
            }
            i++;
        }
        if (enc) {
            System.out.println(libro.toString());
        } else {
            System.out.println("No se encontro el libro.");
        }

    }

    // h) Generar estadísticas (cantidad – promedio - máximo y/o mínimo).
    private static void generarEstadisticas() {
        if (!listaLibros.isEmpty()) {
            double suma = 0;
            double max = -1;
            double min = 9999999;

            for (int i = 0; i < listaLibros.size(); i++) {
                double p = listaLibros.get(i).getPrecio();
                suma = suma + p;
                if (p > max) {
                    max = p;
                }
                if (p < min) {
                    min = p;
                }
            }

            double promedio = suma / listaLibros.size();

            System.out.println("\n--- Estadisticas ---");
            System.out.println("Cantidad de libros: " + listaLibros.size());
            System.out.println("Precio promedio: $" + promedio);
            System.out.println("Precio maximo: $" + max);
            System.out.println("Precio minimo: $" + min + "\n");

        } else {
            System.out.println("No hay datos para estadísticas.");
        }
    }

    private static void inicializarGeneros() {
        listaGeneros.add(new Genero(1, "Novela"));
        listaGeneros.add(new Genero(2, "Ciencia Ficción"));
        listaGeneros.add(new Genero(3, "Aventuras"));
        listaGeneros.add(new Genero(4, "Crimen"));
        listaGeneros.add(new Genero(5, "Romance"));
        listaGeneros.add(new Genero(6, "Detectives"));
        listaGeneros.add(new Genero(7, "Horror"));
        listaGeneros.add(new Genero(8, "Comedia"));
        listaGeneros.add(new Genero(9, "Drama"));
        listaGeneros.add(new Genero(10, "Histórico"));
        listaGeneros.add(new Genero(11, "Infantil"));
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
            System.out.print("Error. Precio no valido.");
        }
        double d = sc.nextDouble();
        sc.nextLine();
        return d;
    }
}