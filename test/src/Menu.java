import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Conexion.conectar();
        } catch (SQLException e) {
            System.out.println("Hubo un error al intentar la conexion con la base de datos:");
            e.printStackTrace();
        }
        int op1 = -1;
        do {
            System.out.println("---Menu Gestion de Libros digitales---");
            System.out.println("1 - Gestionar libros");
            System.out.println("2 - Gestionar generos");
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
                    int op = -1;
                    do {
                        System.out.println("---Gestionar libros---");
                        System.out.println("1 - Cargar Libros");
                        System.out.println("2 - Consultar libros");
                        System.out.println("3 - Borrar libros");
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
                                
                                break;
                            }

                            case 2: {
                                int op2 = -1;
                                
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
                    break;
                }

                case 2:{

                    break;
                }

                case 0:{
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
    }

}
