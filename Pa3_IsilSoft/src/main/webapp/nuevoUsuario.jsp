<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Registro de Usuario</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light d-flex justify-content-center align-items-center" style="min-height: 100vh;">

    <div class="card shadow p-5 rounded" style="max-width: 600px; width: 100%;">
        <h2 class="text-center text-primary mb-4">Registro de Usuario</h2>

        <div class="text-danger text-center mb-3">
        	<c:out value="${mensaje}"/>
        </div>
       
        <h5 class="mb-3">Ingresa tus datos:</h5>
        
		<form action="usuario" method="POST">
		
			<input type="hidden" name="opcionPost" value="registroUsuario">
			
			<div class="mb-3">
				<label for="nombre">Nombre : </label>
				<input id="nombre" name="nombre">
			</div>
			
			<div class="mb-3">
				<label for="apePaterno">Apellido Paterno : </label> 
				<input id="apePaterno" name="apePaterno">
			</div>
			
			<div class="mb-3">
				<label for="apeMaterno">Apellido Materno : </label> 
				<input id="apeMaterno" name="apeMaterno">
			</div>
			
			<div class="mb-3">
				<label for="direccion">Direccion : </label> 
				<input id="direccion" name="direccion">
			</div>
			
			<div class="mb-3">
				<label for="correo">Correo : </label> 
				<input id="correo" name="correo">
			</div>
			
			<div class="mb-4">
				<label for="password">Contrasena : </label> 
				<input id="password" name="password">
			</div>
			
			<button type="submit" class="btn btn-success w-100">Registrar</button>
			
		</form>
	</div>
</body>
</html>