<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Recuperar Contrasena</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
  <div class="container mt-5">
        <div class="card shadow rounded p-4">
			<h1 class="text-center mb-4">Recuperar Contrasena</h1> <br>
			<h3>Buscar Usuario</h3>
				 
				<form action="usuario" method="GET" class="mb-4">
				 
					<input type="hidden" name="opcionGet" value="recuperarContrasena">
				 	
				 	 <div class="mb-3">
				 	 
					 	<label for="correo">Correo: </label>
					 	<input type="text" name="correo" id="correo"><br><br>
					 </div>
					 
					 <button  class="btn btn-primary">Recuperar</button><br><br><br><br>
					 
				 	<div class="mt-3 text-success">
				 		<c:out value="${mensaje}"/>
				 	</div>
				 	
				 	<div class="mt-4">
				 		<h3>Contrasena Recuperada</h3>
				 		<label>Contrasena: </label><input type="text" value="${password}">
				 	</div>
				 		
				 </form>

				 <form action="home" method="POST">
				 	<input type="hidden" name="opcionPost" value="mostrarLogin">
				 	<button class="btn btn-secondary">Regresar al Login</button>
				 </form>
		</div>
	</div>
</body>
</html>