import java.sql.*;

public class Consultas {
	
	public static void consultarLibros(Connection con) throws SQLException {
		String sql = "SELECT id_lib, autor, titulo, editorial, año_edicion, nombre FROM librosdig natural join generos order by id_lib ASC";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		System.out.println("Resultados de la busqueda: ");
		while(rs.next()){
			int id_lib = rs.getInt("id_lib");
			String autor = rs.getString("autor");
			String titulo = rs.getString("titulo");
			String editorial = rs.getString("editorial");
			int anio_edicion = rs.getInt("año_edicion");
			String nombreGenero = rs.getString("nombre");

			System.out.println("ID Libro: " + id_lib + " | Autor: " + autor + " | Titulo: " + titulo + " | Editorial: " + editorial + " | Año de edicion: " + anio_edicion + " | Nombre del genero: " + nombreGenero);
		}
	}



	public static void consultarIdLibro(Connection con, int id) throws SQLException {
		String sql = "SELECT id_lib, autor, titulo, editorial, año_edicion, nombre FROM librosdig natural join generos WHERE id_lib LIKE (?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		System.out.println("Resultados de la busqueda: ");
		while(rs.next()){
			int id_lib = rs.getInt("id_lib");
			String autor = rs.getString("autor");
			String titulo = rs.getString("titulo");
			String editorial = rs.getString("editorial");
			int anio_edicion = rs.getInt("año_edicion");
			String nombreGenero = rs.getString("nombre");

			System.out.println("ID Libro: " + id_lib + " | Autor: " + autor + " | Titulo: " + titulo + " | Editorial: " + editorial + " | Año de edicion: " + anio_edicion + " | Genero: " + nombreGenero);
		}
	}
	

}
