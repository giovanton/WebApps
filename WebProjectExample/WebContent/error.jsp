<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Página de Error</title>
</head>
<body>
	<p>
		Se ha cometido un error,
		<%=exception.getClass().getName() %>
		<!-- sale el nombre de la excepción -->
</body>
</html>