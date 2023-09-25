package DAOs_IMPL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConstantesSQL.ConstantesSQL;
import DAOs.VideojuegosDAO;
import MasterDAO.MasterDAO;
import Modelo.Videojuego;

public class VideojuegosDAO_IMPL extends MasterDAO implements VideojuegosDAO {

	@Override
	public void registrarVideojuego(Videojuego v) {
		conectar();
		try {
			PreparedStatement ps = this.conexion.prepareStatement(ConstantesSQL.SQL_INSERTAR_VIDEOJUEGO);
			
			//
			ps.setString(1, v.getNombre());
			ps.setString(2, v.getDescripcion());
			ps.setString(3, v.getGenero());
			ps.setString(4, v.getPlataformas());
			ps.setDate(5, v.getFechaLanzamiento());
			ps.setString(6, v.getDesarrollador());
			ps.setDouble(7, v.getPuntuacion());
			ps.setDouble(8, v.getPrecio());
			
			ps.execute();
			desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[-] Error al preparar el Statement en registrarVideoJuego() (VideojuegosDAO_IMPL.java)");
			System.out.println(e);
		}
		
	}

	@Override
	public List<Videojuego> obtenerVideojuegos() {
		conectar();
		List<Videojuego> videojuegos = new ArrayList<Videojuego>();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery(ConstantesSQL.SQL_OBTENER_VIDEOJUEGO);
			while(rs.next()) {
				videojuegos.add(
						new Videojuego(
								rs.getInt("id"),
								rs.getString("nombre"),
								rs.getString("descripcion"),
								rs.getString("genero"),
								rs.getString("plataformas"),
								rs.getDate("fechaLanzamiento"),
								rs.getString("desarrollador"),
								rs.getDouble("puntuacion"),
								rs.getDouble("precio")
								)
						);
			}
		} catch (SQLException e) {
			System.out.println("[-] Error en obtenerVideojuegos() (VideojuegosDAO_IMPL.java)");
			System.out.println(e);
		}
		desconectar();
		return videojuegos;
		
	}

	@Override
	public Videojuego obtenerVideojuegoPorId(int id) {
		conectar();
		Videojuego videojuego = new Videojuego();
		try {
			PreparedStatement ps = conexion.prepareStatement(ConstantesSQL.SQL_OBTENER_VIDEOJUEGO_POR_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				videojuego = new Videojuego(
					rs.getInt("id"),
					rs.getString("nombre"),
					rs.getString("descripcion"),
					rs.getString("genero"),
					rs.getString("plataformas"),
					rs.getDate("fechaLanzamiento"),
					rs.getString("desarrollador"),
					rs.getDouble("puntuacion"),
					rs.getDouble("precio")
					);
			}
		} catch (SQLException e) {
			System.out.println("[-] Error en obtenerVideojuegoPorId() (VideojuegosDAO_IMPL.java)");
			System.out.println(e);
		}
		desconectar();
		return videojuego;
	}

	@Override
	public void modificarVideojuego(Videojuego v, int id) {
		conectar();
		try {
			PreparedStatement ps = this.conexion.prepareStatement(ConstantesSQL.SQL_MODIFICAR_VIDEOJUEGO_POR_ID);
			
			//
			ps.setString(1, v.getNombre());
			ps.setString(2, v.getDescripcion());
			ps.setString(3, v.getGenero());
			ps.setString(4, v.getPlataformas());
			ps.setDate(5, v.getFechaLanzamiento());
			ps.setString(6, v.getDesarrollador());
			ps.setDouble(7, v.getPuntuacion());
			ps.setDouble(8, v.getPrecio());
			ps.setInt(9, id);
			
			ps.execute();
			desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[-] Error al preparar el Statement en registrarVideoJuego() (VideojuegosDAO_IMPL.java)");
			System.out.println(e);
		}
		
	}

	@Override
	public void borrarVideojuego(int id) {
		conectar();
		try {
			PreparedStatement ps = conexion.prepareStatement(ConstantesSQL.SQL_BORRAR_VIDEOJUEGO_POR_ID);
			ps.setInt(1, id);
			ps.execute();
			desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[-] Error al borrar videojuego  (VideojuegosDAO_IMPL.java)");
			e.printStackTrace();
		}
		
		
	}

}
