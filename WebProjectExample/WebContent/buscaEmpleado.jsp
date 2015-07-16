<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Resultado de la búsqueda</title>
</head>
<body>


	<table>
		<tr>
			<th>Empleados</th>
		</tr>
		<tr>
			<td>Nombre</td>
			<td>Apellido</td>
			<td>Salario</td>
		</tr>
		<tr>
			<td>${emp.first_name}</td>
			<td>${emp.last_name}</td>
			<td>${emp.salary}</td>
		</tr>
	</table>
</body>
</html>