<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>A�adir Videojuego</title>
</head>
<body>

	<jsp:include page="menu.jsp"></jsp:include>
	<div>
		Nuevo Videojuego
	</div>
	
	<form action="videojuegos/nuevo" method="post">
		Nombre: <input name="nombre" type="text"/><br>
		Descripcion: <textarea rows="3" cols="20" name="descripcion"></textarea><br>
		Genero: <input name="genero" type="text" /><br>
		Plataforma: <select name="plataforma">
	        <option value="pc">PC</option>
	        <option value="playstation4">PlayStation 4</option>
	        <option value="playstation5">PlayStation 5</option>
	        <option value="xboxone">Xbox One</option>
	        <option value="xboxseriesx">Xbox Series X</option>
	        <option value="nintendoswitch">Nintendo Switch</option>
	        <option value="otro">Otro</option>
   		</select> <br>
		Fecha de Lanzamiento: <input type="date" name="fechaLanzamiento"><br>
		Desarrollador: <input type="text" name="desarrollador"><br>
		Puntuacion: <input name="puntuacion" type="number" step="any"/><br>
		Precio: <input name="precio" type="number" step=".01"/><br>
		
		
		<input type="submit" value="Registrar Nuevo Videojuego">
	
	</form>

</body>
</html>