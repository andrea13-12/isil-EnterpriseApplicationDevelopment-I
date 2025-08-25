<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion de Sucursales</title>
</head>
<body>
	<h1>Gestion de Sucursales</h1><br>
		
	<form action="sucursal" method="GET">
		<input type="hidden" name="opcionGet" value="buscarSucursal"> 
		Nombre Sucursal: <input type="text" name="direccion"> 
		<button>Buscar</button><br><br>
	</form>

	<h2>Resultados de Busqueda</h2><br>
	<table border="1">
		<tr>
			<th>Codigo</th>
			<th>Nombre</th>
			<th>Direccion</th>
			<th>Estado</th>
			<th>Acciones</th>
		</tr>
		<c:forEach var="sucursal" items="${listaSucursales}">
			<tr>
				<td>${sucursal.id}</td>
				<td>${sucursal.ruc}</td>
				<td>${sucursal.direccion}</td>
				<td>${sucursal.estado}</td>
				<td>Editar Eliminar</td>
			</tr>
		</c:forEach>
	</table><br><br>
	
	<button>Nuevo</button>
</body>
</html>
