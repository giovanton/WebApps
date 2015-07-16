<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de empleados</title>
</head>
<body>
<table>
		<tr>
			<th><h2>Empleados</h2></th>
		</tr>
		<tr>
			<td><big>Nombre</big></td>
			<td><big>Apellido</big></td>
			<td><big>Salario</big></td>
		</tr>
		<c:forEach var="emp" items="${lem}">
		<tr>
			<td><c:out value="${emp.firstName}"></c:out></td>
			<td><c:out value="${emp.lastName}"></c:out></td>
			<td><c:out value="${emp.salary}"></c:out></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>