<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Jefe de Tienda</title>
</head>
<body>
	<h1>Editar Jefe de Tienda</h1><br>
	
	<form action="jefeTienda" method="POST">
	<input type="hidden" name="opcionPost" value="editarJefes">
	<input type= "hidden" name= "id" value="${jefeTienda.id}">
	
		 Nombre:<input type="text" name="nombre" value="${jefeTienda.nombre}"><br><br>
		 Apellido Paterno:<input type="text" name="apellidoPaterno" value="${jefeTienda.apellidoPaterno}"> <br><br>
		 Apellido Materno:<input type="text" name="apellidoMaterno" value="${jefeTienda.apellidoMaterno}"> <br> <br>
		 DNI:<input type="text" name="dni" value="${jefeTienda.dni}"> <br><br>
		 
		<button>Grabar</button>
		
	</form>
	
</body>
</html>
