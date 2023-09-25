package ConstantesSQL;

public class ConstantesSQL {
	public final static String SQL_INSERTAR_VIDEOJUEGO = 
			"INSERT INTO `videojuego` (`nombre`, `descripcion`, `genero`, `plataformas`, `fechaLanzamiento`, `desarrollador`, `puntuacion`, `precio`) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

	public final static String SQL_OBTENER_VIDEOJUEGO =
			"SELECT * FROM `videojuego`";
	
	public final static String SQL_BORRAR_VIDEOJUEGO_POR_ID =
			"DELETE FROM `videojuego` WHERE `videojuego`.`id` = ?";

	public static final String SQL_OBTENER_VIDEOJUEGO_POR_ID = 
			"SELECT * FROM `videojuego`  WHERE `videojuego`.`id` = ?";
	
	public static final String SQL_MODIFICAR_VIDEOJUEGO_POR_ID  = 
			"UPDATE `videojuego` SET `nombre` = ?, `descripcion` = ?, `genero` = ?,"
			+ " `plataformas` = ?, `fechaLanzamiento` = ?, `desarrollador` = ?, `puntuacion` = ?,"
			+ " `precio` = ? WHERE `videojuego`.`id` = ?";
}
