

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
	
	private static Connection conexion=null;
	
	public static Connection conectar() throws SQLException {
		//Class.forName("com.mysql.jdbc.Driver"); // no es necesario
		String jdbc = "jdbc:mysql://localhost:3306/biblioteca";
		conexion = DriverManager.getConnection(jdbc, "root", "root");
		System.out.println("Conexion OK");
		return conexion;
	}
	
	public static void cerrar() throws  SQLException{
		if (conexion!=null)
			conexion.close();
	}

	public static void main(String[] args) {
		try{
			conectar();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
