<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update emp</title>
</head>
<body>
<center>
<%

String id=request.getParameter("id");
String name=request.getParameter("name");
String salary=request.getParameter("salary");
String phone=request.getParameter("phone");
String password=request.getParameter("password");
String role=request.getParameter("role");
%>
<form action="update_emp" method="post">
<h1 stye="color:red">UPDATE EMPLOYEE DETAILS</h1>
<input type="hidden" name="id" value=<%=id %> ><br>
	Name:<input type="text" name="name" placeholder=<%=name %> ><br>
	Salary:<input type="text" name="salary" placeholder=<%=salary %> ><br>
	Phone:<input type="text" name="phone" placeholder=<%=phone%> ><br>
	Password:<input type="text" name="password" placeholder=<%=password %> ><br>
	Role:<input type="text" name="role" placeholder=<%=role %> ><br>
	<input type="submit" ><br>

</form>
</center>
</body>
</html>