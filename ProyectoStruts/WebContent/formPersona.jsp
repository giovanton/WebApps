<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Form Persona</title>
</head>
<body>
<s:form action="person">
<s:textfield label="Nombre" name="nombre"/>
<s:textfield label="Edad" name="edad"/>
<s:submit value="Enviar"/>
</s:form>

</body>
</html>