<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<!-- no se inicializa la sesión -->
<%@ page errorPage="error.jsp"%>
<%@ page import="org.apache.logging.log4j.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adivina Números</title>
</head>
<body>
	<h1 style="">
		<u>Adivino</u>
	</h1>
	<%!
private int numMax = 100;
private Integer numMin = 0;
private Integer numAdivinado = 0;
Integer n = null;
private static Logger log = LogManager.getRootLogger();
public int adivinar(int numFallado,int numLimite)
{
	numAdivinado = (int)(numFallado+numLimite)/2;
	return numAdivinado;
}
%>
	<br>
	<form action="adivina.jsp">
		Tu número es <input name="num" value="<%=numAdivinado %>"
			style="width: 78px;"><br> <select name="opcion">
			<option value="1">mayor</option>
			<option value="2">menor</option>
			<option value="3">Es este!</option>
		</select> <input type="submit" value="Enviar">
	</form>
	<%
if (request.getParameter("opcion") != null){
switch(Integer.parseInt(request.getParameter("opcion"))){
case 1:
	int numFallado = Integer.parseInt(request.getParameter("num"));
	numMin = numFallado+1;
	numAdivinado = adivinar(numFallado,numMax);
	break;
case 2:
	numFallado = Integer.parseInt(request.getParameter("num"));
	numMax = numFallado-1;
	log.info(numMax);
	numAdivinado = adivinar(numFallado,numMin);
	break;
case 3:
	out.println("¡Acerté!");
	numMax = 100;
	numMin = 0;
	out.println("<a href=\"instrucciones.html\">Empezar de nuevo</a>");
	break;
default:
	break;
}
}else{
	numAdivinado = (int)Math.floor(Math.random()*(100-1+1))+1;
}
	%>


</body>
</html>