package DAOs_IMPL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import ConstantesSQL.ConstantesSQL;
import DAOs.VideojuegosDAO;
import Mapers.VideojuegoMapper;
import MasterDAO.MasterDAO;
import Modelo.Videojuego;

public class VideojuegosDAO_IMPL extends MasterDAO implements VideojuegosDAO {

	private static DataSource dsVideojuegosDAO;
	private static SimpleJdbcInsert simpleInsert;
	private static JdbcTemplate jdbcTemplate;

	public void setDsLibrosDAO(DataSource dsVideojuegosDAO) {

		// Vamos a usar Spring jdbc:
		/*
		 * Hace falta: una bean Datasource con los datos de la conexión -> (ya definida
		 * en el applicationContext.xml)
		 */
		// Hacen falta las librerias de Spring
		// Hace falta tener bien configurados los archivos web.xml y
		// applicationContext.xml

		// Como uso Spring jdbc:
		// El DAO_IMPL debe recibir el datasource para usarlo en sus operaciones
		// Eso lo hacemos indicando en el xml lo siguiente:
		/*
		 * <bean class="DAOs_IMPL.LibrosDAO_IMPL"> <property name="dsLibrosDAO"
		 * ref="dataSource"/> </bean>
		 */
		// Con lo indicado se ejecuta el setDsLibrosDAO el cual recibe el dataSource
		// Y ya podemos preparar ciertos recursos:
		this.simpleInsert = new SimpleJdbcInsert(dsVideojuegosDAO);
		this.simpleInsert.withTableName("tabla_videojuegos");

		// Vamos a preparar otro recurso de spring que nos va a ayudar con el resto de
		// consultas
		this.jdbcTemplate = new JdbcTemplate(dsVideojuegosDAO);

		this.dsVideojuegosDAO = dsVideojuegosDAO;
	}

	@Override
	public void registrarVideojuego(Videojuego v) {
		
		HashMap<String, Object> valores = new HashMap<String, Object>();
	
		valores.put("nombre", v.getNombre());
		valores.put("descripcion", v.getDescripcion());
		valores.put("genero", v.getGenero());
		valores.put("plataformas", v.getPlataformas());
		valores.put("fechaLanzamiento", v.getFechaLanzamiento());
		valores.put("desarrollador", v.getDesarrollador());
		valores.put("puntuacion", v.getPuntuacion());
		valores.put("precio", v.getPrecio());

		this.simpleInsert.execute(valores);

	}

	@Override
	public List<Videojuego> obtenerVideojuegos() {
		List<Videojuego> videojuegos = this.jdbcTemplate.query(ConstantesSQL.SQL_OBTENER_VIDEOJUEGO,new VideojuegoMapper());
		
		return videojuegos;

	}

	@Override
	public Videojuego obtenerVideojuegoPorId(int id) {
		Videojuego l  = jdbcTemplate.queryForObject(
				ConstantesSQL.SQL_OBTENER_VIDEOJUEGO_POR_ID,
				new Object[] {id},
				new VideojuegoMapper());
	return l;
	}

	@Override
	public void modificarVideojuego(Videojuego v, int id) {
		this.jdbcTemplate.update(ConstantesSQL.SQL_MODIFICAR_VIDEOJUEGO_POR_ID, 
				v.getNombre(),
				v.getDescripcion(),
				v.getGenero(),
				v.getPlataformas(),
				v.getFechaLanzamiento(),
				v.getDesarrollador(),
				v.getPuntuacion(),
				v.getPrecio(),
				id);
		

	}

	@Override
	public void borrarVideojuego(int id) {
		this.jdbcTemplate.update(ConstantesSQL.SQL_BORRAR_VIDEOJUEGO_POR_ID, id);

	}

}
