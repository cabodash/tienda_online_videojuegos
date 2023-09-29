package Mapers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Modelo.Videojuego;

public class VideojuegoMapper implements RowMapper<Videojuego>{

	@Override
	public Videojuego mapRow(ResultSet rs, int arg1) throws SQLException {
		Videojuego v = new Videojuego(
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
		return v;
	}

}
