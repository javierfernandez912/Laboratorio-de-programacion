import java.sql.*;
public class Bajas {
    public static void baja(Connection con, int id) throws SQLException{
		String LIBROSDIG = "DELETE FROM LIBROSDIG WHERE id_lib = ?";
		PreparedStatement librosdig=null;

		try {

			librosdig = con.prepareStatement(LIBROSDIG);
			librosdig.setInt(1, id);
			librosdig.executeUpdate();
			
			System.out.println("Libro borrado.");
		} catch (SQLException e) {
			System.out.println("No se pudo borrar el libro");
			e.printStackTrace();
		} finally {
			if (librosdig!=null)
				librosdig.close();
		}
	}
}
