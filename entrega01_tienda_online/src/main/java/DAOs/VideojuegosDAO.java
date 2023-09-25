package DAOs;

import java.util.List;

import Modelo.Videojuego;

public interface VideojuegosDAO {
	
	void registrarVideojuego(Videojuego v);
	
	List<Videojuego> obtenerVideojuegos();
	
	Videojuego obtenerVideojuegoPorId(int id);
	
	void modificarVideojuego(Videojuego v, int id);
	
	void borrarVideojuego(int id);

}
