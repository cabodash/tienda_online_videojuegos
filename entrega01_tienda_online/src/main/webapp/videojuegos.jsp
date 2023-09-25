<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="menu.jsp"></jsp:include>

	<div>Gestión de Videojuegos</div>
	
	<div>
		<a href="${pageContext.servletContext.contextPath}/videojuego_nuevo.jsp">Registrar un Videojuego</a>
	</div>
	
		Listado de Videojuegos <br>
		<C:forEach items="${info}" var="videojuego">
			<div style="margin: 10px; background-color: lightblue; width:fit-content; padding: 0.5em; border-radius: 10px; " >
				Nombre: ${videojuego.nombre} <br>
				Descripcion: ${videojuego.descripcion} <br>
				Genero: ${videojuego.genero} <br>
				Plataformas: ${videojuego.plataformas} <br>
				Fecha de Lanzamiento: ${videojuego.fechaLanzamiento} <br>
				Desarrollador: ${videojuego.desarrollador} <br>
				Puntuacion: ${videojuego.puntuacion} <br>
				Precio: ${videojuego.precio} <br>
				
				<a href="editar?id=${videojuego.id}">Editar</a>
				<a href="borrar?id=${videojuego.id}" onclick="return confirm('Estás Seguro')">Borrar</a>
				
				
			</div>
			
		</C:forEach>

</body>
</html>