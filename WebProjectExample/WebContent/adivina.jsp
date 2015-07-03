<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adivina Números</title>
</head>
<body>
<h1 style="align"><u>Adivino</u></h1>
<%!
int numMax = 100;
Integer numMin = 0;
Integer numAdivinado = 0;
public int adivinar(int numFallado,int numLimite)
{
	numAdivinado = (int)(numFallado+numLimite)/2;
	return numAdivinado;
}
%>
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
	numAdivinado = adivinar(numFallado,numMin);
	break;
case 3:
	out.println("¡Acerté!");
	break;
default:
	break;
}
}else{
	numAdivinado = (int)Math.floor(Math.random()*(100-1+1))+1;
}
	%>

<br>
<form action="adivina.jsp">
Tu número es 
<input name ="num" value="<%=numAdivinado %>" style=" width : 78px;"><br>
<select name="opcion">
<option value="1">mayor</option>
<option value="2">menor</option>
<option value="3">Es este!</option>
</select>
<input type="submit" value="Enviar">
</form>
</body>
</html>