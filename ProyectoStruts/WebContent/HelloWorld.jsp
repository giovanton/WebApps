<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello World!</title>
</head>
<body>
<!-- <h2><s:property value="messageStore.message" /></h2>-->
<h2><s:property value="nombre" /> <s:property value="edad" /></h2>
<s:if test="hasActionMessages()"><s:actionmessage/></s:if>
</body>
</html>