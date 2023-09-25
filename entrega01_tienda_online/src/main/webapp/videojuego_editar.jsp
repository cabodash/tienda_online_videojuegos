<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Videojuego</title>
</head>
<body>


	<jsp:include page="menu.jsp"></jsp:include>
	<div>
		Editar Videojuego
	</div>
	
	<form action="${pageContext.servletContext.contextPath}/videojuegos/guardar-cambios" method="post">
		<input name="id" type="hidden" value ="${videojuego.id}"/><br>
		Nombre: <input name="nombre" type="text" value ="${videojuego.nombre}"/><br>
		Descripcion: <textarea rows="3" columns="20" name="descripcion" >${videojuego.descripcion}</textarea><br>
		Genero: <input name="genero" type="text" value ="${videojuego.genero}"/><br>
		Plataformas: <input name="plataformas" type="text" value ="${videojuego.plataformas}"/><br>
		Fecha de Lanzamiento: <input type="date" name="fechaLanzamiento" value ="${videojuego.fechaLanzamiento}"><br>
		Desarrollador: <input type="text" name="desarrollador" value ="${videojuego.desarrollador}"><br>
		Puntuacion: <input name="puntuacion" type="number" step=".01" value ="${videojuego.puntuacion}"/><br>
		Precio: <input name="precio" type="number" step="any" value ="${videojuego.precio}"/><br>
		
		
		<input type="submit" value="Guardar Cambios">
	
	</form>

</body>
</html>