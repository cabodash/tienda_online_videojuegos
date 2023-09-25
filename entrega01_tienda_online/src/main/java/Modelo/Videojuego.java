package Modelo;

import java.sql.Date;
import java.util.List;
import ENUM_VideoJuego.Plataforma;

public class Videojuego {
	private int id;
	private String nombre;
	private String descripcion;
	private String genero;
    private String plataformas;
    private Date fechaLanzamiento;
    private String desarrollador;
    private double puntuacion;
    private double precio;
    
    
    
    public Videojuego() {
		// TODO Auto-generated constructor stub
	}


	public Videojuego(int id, String nombre, String descripcion, String genero, String plataformas,
			Date fechaLanzamiento, String desarrollador, double puntuacion, double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.genero = genero;
		this.plataformas = plataformas;
		this.fechaLanzamiento = fechaLanzamiento;
		this.desarrollador = desarrollador;
		this.puntuacion = puntuacion;
		this.precio = precio;
		
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getPlataformas() {
		return plataformas;
	}


	public void setPlataformas(String plataformas) {
		this.plataformas = plataformas;
	}


	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}


	public void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}


	public String getDesarrollador() {
		return desarrollador;
	}


	public void setDesarrollador(String desarrollador) {
		this.desarrollador = desarrollador;
	}


	public double getPuntuacion() {
		return puntuacion;
	}


	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
    
	
    
	

}
