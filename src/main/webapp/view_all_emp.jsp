<%@page import="model.dto.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>allempdetails</title>
</head>
<body>
<center>
<%
List<Employee> employeess = (List<Employee>)request.getAttribute("employeess");
%>


<table>
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Salary</th>
		<th>Phone</th>
		<th>Password</th>
		<th>Role</th>
		<th></th>
		<th></th>
	</tr>
	
	<% 
	if (employeess != null && !employeess.isEmpty()) {
		for(Employee emp : employeess) {
	%>
	<tr>
		<td><%= emp.getId() %></td>
		<td><%= emp.getName() %></td>
		<td><%= emp.getSalary() %></td>
		<td><%= emp.getPhone() %></td>
		<td><%= emp.getPassword() %></td>
		<td><%= emp.getRole() %></td>
		<td><a href="remove_emp?id=<%= emp.getId() %>">Remove Employee</a></td>
		<td><a href="update_emp.jsp?id=<%= emp.getId() %>&name=<%= emp.getName() %>&salary=<%= emp.getSalary() %>&phone=<%= emp.getPhone() %>
			&password=<%= emp.getPassword() %>&role=<%= emp.getRole() %>">Update Employee</a></td>
	</tr>
	<% 
		}
	} else {
	%>
	<tr>
		<td colspan="8">No employees found.</td>
	</tr>
	<%
	}
	%>
</table>
</center>
</body>
</html>