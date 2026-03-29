
import java.sql.*;

public class ejemplo4 {

	public Connection conexion = null;

	public ejemplo4() throws SQLException{
		try {
			conectar();
			sentenciaPreparada();
		} finally {
			cerrar();
 		}
	}
	
	public void conectar() throws SQLException {
		String jdbc = "jdbc:mysql://localhost/biblioteca";
		conexion = DriverManager.getConnection(jdbc, "root", "root");
		System.out.println("Conexion OK");
	}

	public void cerrar() throws SQLException{
		if (conexion != null) {
			conexion.close();
			System.out.println("Conexion cerrada");
		}
	}

	private void sentenciaPreparada() throws SQLException{
		String GENEROS = "INSERT INTO generos (genero_id, nombre) VALUES (?, ?)";
		String LIBROSDIG = "INSERT INTO librosdig (id_lib, titulo, autor, editorial, año_edicion, genero_id) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement generos=null, librosdig=null;

		try {
			generos = conexion.prepareStatement(GENEROS);
			generos.setInt(1,3);
			generos.setString(2,"Comedia");
			generos.executeUpdate();

			librosdig= conexion.prepareStatement(LIBROSDIG);
			librosdig.setInt(1,3);
			librosdig.setString(2,"Chistes de yayo");
			librosdig.setString(3,"Yayo Guridi");
			librosdig.setString(4,"Alguna editorial cordobesa");
			librosdig.setInt(5,2010);
			librosdig.setInt(6,3);
			librosdig.executeUpdate();
			
			System.out.println("Sentencia PreparedStatement OK");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(generos!=null) 
				generos.close();
			if (librosdig!=null)
				librosdig.close();
		}
	}

	public static void main(String args[]) {
		try {
			new ejemplo4();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}