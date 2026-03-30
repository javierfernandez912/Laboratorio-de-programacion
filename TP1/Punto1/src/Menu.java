import java.sql.*;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Connection con;

    public Menu() {
        this.scanner = new Scanner(System.in);
        try {
            this.con = Conexion.conectar();
        } catch (SQLException e) {
            System.out.println("Hubo un error al intentar la conexion con la base de datos:");
            e.printStackTrace();
        }
    }

    public void start() {
        if (this.con != null) {
            int op1 = -1;
            do {
                System.out.println("---Menu Gestion de Libros digitales---");
                System.out.println("1 - Gestionar libros");
                System.out.println("0 - Salir");
                System.out.println("Ingrese una opcion:");
                while (!scanner.hasNextInt()) {
                    System.out.println("Error: Ingrese un número válido");
                    scanner.next();
                }
                op1 = scanner.nextInt();
                scanner.nextLine();
                switch (op1) {
                    case 1: {
                        menuLibros();
                        break;
                    }


                    case 0: {
                        System.out.println("Saliendo...");
                        break;
                    }
                    default: {
                        System.out.println("Opcion no valida");
                        break;
                    }
                }
            } while (op1 != 0);

            try {
                Conexion.cerrar();
            } catch (SQLException e) {
                e.printStackTrace();
            } // cierra la conexion con la bd al salir del menu.
        } else {
            System.out.println("No se puede iniciar el menu si no hay conexion con la base de datos");
        }
    }

    private void menuLibros() {
        int op = -1;
        do {
            System.out.println("---Gestionar libros---");
            System.out.println("1 - Cargar Libros");
            System.out.println("2 - Consultar libros");
            System.out.println("3 - Borrar libros");
            System.out.println("4 - Modificar libro");
            System.out.println("0 - Volver al menu principal");
            System.out.println("Ingrese una opcion:");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.next();
            }
            op = scanner.nextInt();
            scanner.nextLine();
            switch (op) {
                case 1: {
                    menuCargas();
                    break;
                }

                case 2: {
                    menuConsultas();
                    break;
                }

                case 3:{
                    menuBorrar();
                    break;
                }

                case 4:{
                    menuModificar();
                    break;
                }

                case 0: {
                    System.out.println("Volviendo al menu principal...");
                    break;
                }
                default: {
                    System.out.println("Opcion no valida.");
                    break;
                }
            }

        } while (op != 0);

    }

    private void menuConsultas() {
        int op3 = -1;
        do {
            System.out.println("1 - Mostrar todos los libros");
            System.out.println("2 - Buscar libro por ID");
            System.out.println("0 - Salir");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: Ingrese un número válido");
                scanner.next();
            }
            op3 = scanner.nextInt();
            scanner.nextLine();
            switch (op3) {
                case 1: {
                    try {
                        Consultas.consultarLibros(con);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 2: {
                    int id = -1;
                    System.out.println("Ingrese el id del libro");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Error: Ingrese un número válido");
                        scanner.next();
                    }
                    id = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        Consultas.consultarIdLibro(con, id);

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                }

            }

        } while (op3 != 0);
    }

    private void menuCargas() {
        String titulo, autor, editorial;
        int anio, id;
        

        System.out.println("Ingrese el titulo del libro");
        titulo = scanner.nextLine();
        while(titulo == null || titulo.isEmpty() || titulo.length()>=50){
            System.out.println("Titulo no valido, ingresar nuevamente:");
            scanner.next();
        }

        System.out.println("Ingrese el autor del libro");
        autor = scanner.nextLine();
        while(autor == null || autor.isEmpty() || autor.length()>=30){
            System.out.println("Autor no valido, ingresar nuevamente:");
            scanner.next();
        }

        System.out.println("Ingrese la editorial del libro");
        editorial = scanner.nextLine();
        while(editorial == null || editorial.isEmpty() || editorial.length()>=50){
            System.out.println("Editorial no valida, ingresar nuevamente:");
            scanner.next();
        }

        System.out.println("Ingrese el año de edicion del libro");
        while (!scanner.hasNextInt()) {
                System.out.println("Error: Ingrese un número válido");
                scanner.next();
            }
            anio = scanner.nextInt();
            scanner.nextLine();

        System.out.println("Ingrese el ID del genero del libro");
        while (!scanner.hasNextInt()) {
                System.out.println("Error: Ingrese un número válido");
                scanner.next();
            }
            id = scanner.nextInt();
            scanner.nextLine();

        try{
            Cargas.cargar(con, titulo, autor, editorial, anio, id);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    private void menuBorrar(){
        int id;
        System.out.println("Ingrese el id del libro que desea borrar de la base de datos:");
        while (!scanner.hasNextInt()) {
                System.out.println("Error: Ingrese un número válido");
                scanner.next();
            }
            id = scanner.nextInt();
            scanner.nextLine();
        try{
            Bajas.baja(con, id);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    private void menuModificar(){
        String titulo, autor, editorial;
        int anio, id_lib, id_gen;
        
        System.out.println("Ingrese el ID del libro que quiere modificar:");
         while (!scanner.hasNextInt()) {
                System.out.println("Error: Ingrese un número válido");
                scanner.next();
            }
            id_lib = scanner.nextInt();
            scanner.nextLine();

        System.out.println("Ingrese el titulo del libro");
        titulo = scanner.nextLine();
        while(titulo == null || titulo.isEmpty() || titulo.length()>=50){
            System.out.println("Titulo no valido, ingresar nuevamente:");
            scanner.next();
        }

        System.out.println("Ingrese el autor del libro");
        autor = scanner.nextLine();
        while(autor == null || autor.isEmpty() || autor.length()>=30){
            System.out.println("Autor no valido, ingresar nuevamente:");
            scanner.next();
        }

        System.out.println("Ingrese la editorial del libro");
        editorial = scanner.nextLine();
        while(editorial == null || editorial.isEmpty() || editorial.length()>=50){
            System.out.println("Editorial no valida, ingresar nuevamente:");
            scanner.next();
        }

        System.out.println("Ingrese el año de edicion del libro");
        while (!scanner.hasNextInt()) {
                System.out.println("Error: Ingrese un número válido");
                scanner.next();
            }
            anio = scanner.nextInt();
            scanner.nextLine();

        System.out.println("Ingrese el ID del genero del libro");
        while (!scanner.hasNextInt()) {
                System.out.println("Error: Ingrese un número válido");
                scanner.next();
            }
            id_gen = scanner.nextInt();
            scanner.nextLine();

        try{
            Modificaciones.modificar(con, id_lib, titulo, autor, editorial, anio, id_gen);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}
