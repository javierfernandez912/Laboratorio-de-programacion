import java.sql.*;
public class Modificaciones {
    public static void modificar(Connection con,int id, String titulo, String autor, String editorial, int anio, int genero_id) throws SQLException{
		String LIBROSDIG = "UPDATE librosdig set titulo = ?, autor = ?, editorial = ?, año_edicion = ?, genero_id = ? WHERE id_lib = ?";
		PreparedStatement librosdig=null;

		try {

			librosdig = con.prepareStatement(LIBROSDIG);
			librosdig.setString(1, titulo);
			librosdig.setString(2,autor);
			librosdig.setString(3,editorial);
			librosdig.setInt(4,anio);
			librosdig.setInt(5, genero_id);
            librosdig.setInt(6, id);
			librosdig.executeUpdate();
			
			System.out.println("Libro modificado.");
		} catch (SQLException e) {
			System.out.println("No se pudo realizar la modificacion del libro");
			e.printStackTrace();
		} finally {
			if (librosdig!=null)
				librosdig.close();
		}
	}
}
