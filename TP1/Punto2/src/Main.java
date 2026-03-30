import java.util.Scanner;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Connection con = Conexion.conectar();
        if (con != null) {
            int op = -1;
            do {
                System.out.println("---Menu bancario---");
                System.out.println("1 - Realizar extraccion");
                System.out.println("2 - Realizar deposito");
                System.out.println("0 - Salir");
                System.out.println("Ingrese una opcion:");
                while (!scanner.hasNextInt()) {
                    System.out.println("Error: Ingrese un número válido");
                    scanner.next();
                }
                op = scanner.nextInt();
                scanner.nextLine();
                switch (op) {
                    case 1: {
                        int nroCuenta = -1;
                        double dinero = -1;
                        System.out.println("Ingrese el numero de cuenta de la cual desea realizar una extraccion:");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Error: Ingrese un número válido");
                            scanner.next();
                        }
                        nroCuenta = scanner.nextInt();
                        System.out.println("Ingrese el dinero a extraer");
                        while (!scanner.hasNextDouble()) {
                            System.out.println("Error: Ingrese un número válido");
                            scanner.next();
                        }
                        dinero = scanner.nextDouble();
                        try {
                            Movimientos.extraerCuenta(con, nroCuenta, dinero);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    }

                    case 2: {
                        int nroCuenta = -1;
                        double dinero = -1;
                        System.out.println("Ingrese el numero de cuenta a la cual desea realizar un deposito:");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Error: Ingrese un número válido");
                            scanner.next();
                        }
                        nroCuenta = scanner.nextInt();
                        System.out.println("Ingrese el dinero a depositar");
                        while (!scanner.hasNextDouble()) {
                            System.out.println("Error: Ingrese un número válido");
                            scanner.next();
                        }
                        dinero = scanner.nextDouble();
                        try {
                            Movimientos.depositarCuenta(con, nroCuenta, dinero);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
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
            } while (op != 0);
            Conexion.cerrar();
        }
        scanner.close();

    }
}
