package Controladores;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOs.VideojuegosDAO;
import DAOs_IMPL.VideojuegosDAO_IMPL;
import Modelo.Videojuego;

/**
 * Servlet implementation class ControladorVideojuego
 */
@WebServlet("/videojuegos/*")
public class ControladorVideojuego extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String operacion = request.getPathInfo().substring(1);
		System.out.println("Operacion: " + operacion);
		
		VideojuegosDAO videojuegosDAO = new VideojuegosDAO_IMPL();
		if (operacion.equals("obtener")) {
			mostrarListadoVideojuegos(videojuegosDAO, request, response);
		
			
		}else if(operacion.equals("nuevo")) {
			
			Videojuego videojuegoNuevo = new Videojuego();
			videojuegoNuevo.setNombre(request.getParameter("nombre"));
			videojuegoNuevo.setDescripcion(request.getParameter("descripcion"));
			videojuegoNuevo.setGenero(request.getParameter("genero"));
			videojuegoNuevo.setPlataformas(request.getParameter("plataformas"));
			
			String fechaLanzamientoStr = request.getParameter("fechaLanzamiento");

			try {
			    Date fechaLanzamiento = Date.valueOf(fechaLanzamientoStr); // Convierte la cadena en java.sql.Date
			    videojuegoNuevo.setFechaLanzamiento(fechaLanzamiento);
			} catch (IllegalArgumentException e) {
			    System.out.println("[-] Error en el casteo de la fecha en la operacion nuevo (ControladorVideojuego.java)");
			    e.printStackTrace();
			}
			
			videojuegoNuevo.setDesarrollador(request.getParameter("nombre"));
			videojuegoNuevo.setPuntuacion(Double.parseDouble(request.getParameter("puntuacion")));
			videojuegoNuevo.setPrecio(Double.parseDouble(request.getParameter("precio")));

					
			videojuegosDAO.registrarVideojuego(videojuegoNuevo);
			RequestDispatcher rd= getServletContext().getRequestDispatcher("/videojuego_nuevo_ok.jsp");
			rd.forward(request, response);
			
			
		}else if(operacion.equals("borrar")) {
			
			
			
		}else if(operacion.equals("editar")) {
			int idEditar = Integer.parseInt(request.getParameter("id"));
			System.out.println("Mostrando datos del videojuego con id" + idEditar);
			Videojuego videojuego = videojuegosDAO.obtenerVideojuegoPorId(idEditar);
			request.setAttribute("videojuego", videojuego);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/videojuego_editar.jsp");
			rd.forward(request, response);
			
			
			
		}else if(operacion.equals("guardar-cambios")) {
			Videojuego vNuevo = new Videojuego();
			int id = Integer.parseInt(request.getParameter("id"));
			vNuevo.setNombre(request.getParameter("nombre"));
			vNuevo.setDescripcion(request.getParameter("descripcion"));
			vNuevo.setGenero(request.getParameter("genero"));
			vNuevo.setPlataformas(request.getParameter("plataformas"));
			
			String fechaLanzamientoStr = request.getParameter("fechaLanzamiento");
			try {
			    Date fechaLanzamiento = Date.valueOf(fechaLanzamientoStr); // Convierte la cadena en java.sql.Date
			    vNuevo.setFechaLanzamiento(fechaLanzamiento);
			} catch (IllegalArgumentException e) {
			    System.out.println("[-] Error en el casteo de la fecha en la operacion editar (ControladorVideojuego.java)");
			    e.printStackTrace();
			}
			vNuevo.setDesarrollador(request.getParameter("desarrollador"));
			vNuevo.setPuntuacion(Double.parseDouble(request.getParameter("puntuacion")));
			vNuevo.setPrecio(Double.parseDouble(request.getParameter("precio")));

			
			System.out.println("[i] Id del videojuego a modificar: " + id);
			videojuegosDAO.modificarVideojuego(vNuevo, id);
			mostrarListadoVideojuegos(videojuegosDAO, request, response);
		}
		
	} // end service()
	
	private void mostrarListadoVideojuegos(VideojuegosDAO videojuegosDAO, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Videojuego> videojuegos = videojuegosDAO.obtenerVideojuegos();
		request.setAttribute("info", videojuegos);
		
		RequestDispatcher rd= getServletContext().getRequestDispatcher("/videojuegos.jsp");
		rd.forward(request, response);
	}

}
