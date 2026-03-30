import java.sql.*;

public class Cargas {

	public static void cargar(Connection con, String titulo, String autor, String editorial, int anio, int genero_id) throws SQLException{
		String LIBROSDIG = "INSERT INTO librosdig (id_lib, titulo, autor, editorial, año_edicion, genero_id) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement librosdig=null;

		try {

			librosdig = con.prepareStatement(LIBROSDIG);
			librosdig.setInt(1,0);
			librosdig.setString(2, titulo);
			librosdig.setString(3,autor);
			librosdig.setString(4,editorial);
			librosdig.setInt(5,anio);
			librosdig.setInt(6, genero_id);
			librosdig.executeUpdate();
			
			System.out.println("Libro cargado.");
		} catch (SQLException e) {
			System.out.println("No se pudo realizar la carga del libro");
			e.printStackTrace();
		} finally {
			if (librosdig!=null)
				librosdig.close();
		}
	}
	
}