

import java.sql.*;

public class Consultas {
	
	private Connection conexion=null;
	
	public static void consultarLibros() throws SQLException {
		Connection con = Conexion.conectar();
		String sql = "SELECT id_lib, autor, titulo, editorial, año_edicion, nombre FROM librosdig natural join generos";
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

	public static void consultarTitulo(String nombreLibro) throws SQLException {
		Connection con = Conexion.conectar();
		String sql = "SELECT id_lib, autor, titulo, editorial, año_edicion, nombre FROM librosdig natural join generos WHERE titulo LIKE (?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%" + nombreLibro + "%");
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

	public static void consultarEditorial(String editor) throws SQLException {
		Connection con = Conexion.conectar();
		String sql = "SELECT id_lib, autor, titulo, editorial, año_edicion, nombre FROM librosdig natural join generos WHERE editorial LIKE (?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%" + editor + "%");
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


	public static void consultarIdLibro(int id) throws SQLException {
		Connection con = Conexion.conectar();
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

			System.out.println("ID Libro: " + id_lib + " | Autor: " + autor + " | Titulo: " + titulo + " | Editorial: " + editorial + " | Año de edicion: " + anio_edicion + " | Nombre del genero: " + nombreGenero);
		}
	}
	
	public void cerrar() throws  SQLException{
		if (conexion!=null)
			conexion.close();
	}

	

}
