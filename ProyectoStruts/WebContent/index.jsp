<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Basic Struts 2 Application - Welcome</title>
</head>
<body>
<h1>Welcome To Struts 2!</h1>
<p><a href="<s:url action='hello'/>">Hello World</a></p>
<s:form action="empleado">
<s:textfield label="Id de Empleado" name="id"/>
<s:submit value="Enviar"/>
</s:form>
<s:form action="coche">
<s:textfield label="Marca del coche" name="coche"/>
<s:textfield label="Matrícula" name="coche"/>
<s:submit value="Enviar"/>
</s:form>
</body>
</html>