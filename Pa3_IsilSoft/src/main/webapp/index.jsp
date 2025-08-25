<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Ingreso al Sistema</title>
		 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body class="bg-light d-flex justify-content-center align-items-center" style="height: 100vh;">
    <div class="card p-5 shadow-lg rounded" style="min-width: 400px;">
        <h2 class="text-center text-primary mb-4">Bienvenido a ISIL SOFT S.A.C</h2>

        <div class="text-danger mb-3">
        	<c:out value="${mensaje}"/>
        </div>
		
		<form action="home" method="POST">
			<input type="hidden" name="opcionPost" value="validacionUsuario">
			
			 <div class="mb-3">
				<label for="correo">Correo Electronico:</label> 
				<input type="text" name="correo" id="correo">
			</div>
			
			<div class="mb-4">
				<label for="password">Contrasena:</label> 
				<input type="password" name="password" id="password">
			</div>
			
				
			<button type="submit" class="btn btn-primary w-100">Ingresar</button><br>
		</form>
		
		<div class="text-center mt-4">
			<a href="usuario?opcionGet=mostrarCrearUsuario">Crear Usuario</a><br><br>
			<a href="usuario?opcionGet=mostrarRecuperarContrasena">Olvide mi contrasena</a>
		</div>
	</div>
	
	</body>
	
</html>