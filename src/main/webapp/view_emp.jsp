<%@page import="model.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view emp</title>
</head>
<body>
<center>
<%
Employee emp=(Employee)request.getAttribute("employee");
%>
		<h1>Employee Details</h1><br><br>
		<h2>Employee Id:<%emp.getId(); %></h2>
		<h2>Employee NAME:<%emp.getName(); %></h2>
		<h2>Employee SALARY:<%emp.getSalary(); %></h2>
		<h2>Employee PHONE:<%emp.getPhone(); %></h2>
		<h2>Employee ROLE:<%emp.getRole(); %></h2>
</center>
</body>
</html>