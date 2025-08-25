<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion de Jefes de Tienda</title>
</head>
<body>
    <h1>Gestion de Jefes de Tienda</h1> <br> <br>

    <form action="jefeTienda" method="GET">
        <input type="hidden" name="opcionGet" value="buscarJefeTienda">
        Apellido Paterno: <input type="text" name="apellidoPaterno">
        Apellido Materno: <input type="text" name="apellidoMaterno">
        <button>Buscar</button> <br><br>
    </form>

    <table border="1">
        <tr>
            <td>Codigo</td>
            <td>Nombre</td>
            <td>Apellido Paterno</td>
            <td>Apellido Materno</td>
            <td>DNI</td>
            <td>Acciones</td>
        </tr>
        
        <c:forEach var="jefeTienda" items="${listarjefe}">
            <tr>
                <td>${jefeTienda.id}</td>
                <td>${jefeTienda.nombre}</td>
                <td>${jefeTienda.apellidoPaterno}</td>
                <td>${jefeTienda.apellidoMaterno}</td>
                <td>${jefeTienda.dni}</td>
                <td>
                    <a href="jefeTienda?opcionGet=editar&id=${jefeTienda.id}">Editar</a>
                    <a href="jefeTienda?opcionGet=eliminar&id=${jefeTienda.id}">Eliminar</a>
                </td>
            </tr>
        </c:forEach>
        
    </table>

    <br><br>
    <form action="jefeTienda" method="POST">
        <input type="hidden" name="opcionPost" value="mostrarNuevoJefe">
        <button>Nuevo</button>
    </form>

</body>
</html>