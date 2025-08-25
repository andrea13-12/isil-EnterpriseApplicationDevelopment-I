<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo Jefe de Tienda</title>
</head>
<body>
	<h1>Nuevo Jefe de Tienda</h1><br>
	
	<form action="jefeTienda" method="POST">
	<input type="hidden" name="opcionPost" value="agregarJefes">
	
		 Nombre:<input type="text" name="nombre"><br><br>
		 Apellido Paterno:<input type="text" name="apellidoPaterno"> <br><br>
		 Apellido Materno:<input type="text" name="apellidoMaterno"> <br> <br>
		 DNI:<input type="text" name="dni"> <br><br>
		<button>Grabar</button>
		
	</form>
	
</body>
</html>