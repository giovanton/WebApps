<%@page import="servletOne.recupEmpDept.RecupEmpDept"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="servletOne.dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Recuperar empleados por departamento</title>
</head>
<body>
	<form action="RecupEmpDept" method="get">
		<select name="departamentos">
			<%
				List<Departments> lds = (List<Departments>) request
						.getAttribute("deps");
				Iterator<Departments> it = lds.iterator();
				while (it.hasNext()) {
					Departments d = (Departments) it.next();
			%>
			<option value="<%=d.getDepartmentId()%>"><%=d.getDepartmentName()%></option>
			<%
				}
			%>
		</select> <input type="submit" value="aceptar">
	</form>
</body>
</html>