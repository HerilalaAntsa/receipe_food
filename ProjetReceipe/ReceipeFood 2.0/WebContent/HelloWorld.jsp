<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.*,
				s6.ReceipeFood.modele.*,
				s6.ReceipeFood.service.*,
				java.util.List,
				org.json.*,
				java.sql.*" 
%>
<%
Utilisateur user = (Utilisateur)session.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello World</title>
</head>
<body>
Hello <% out.println(user.getNom()); %>
</body>
</html>