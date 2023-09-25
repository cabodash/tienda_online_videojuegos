<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Añadir Videojuego</title>
</head>
<body>

	<jsp:include page="menu.jsp"></jsp:include>
	<div>
		Nuevo Videojuego
	</div>
	
	<form action="videojuegos/nuevo" method="post">
		Nombre: <input name="nombre" type="text"/><br>
		Descripcion: <textarea rows="3" columns="20" name="descripcion"></textarea><br>
		Genero: <input name="genero" type="text" /><br>
		Plataforma: <input name="plataformas" type="text"/><br>
		Fecha de Lanzamiento: <input type="date" name="fechaLanzamiento"><br>
		Desarrollador: <input type="text" name="desarrollador"><br>
		Puntuacion: <input name="puntuacion" type="number" step="any"/><br>
		Precio: <input name="precio" type="number" step="any"/><br>
		
		
		<input type="submit" value="Registrar Nuevo Videojuego">
	
	</form>

</body>
</html>