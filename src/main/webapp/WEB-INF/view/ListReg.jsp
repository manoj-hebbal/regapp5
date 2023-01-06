<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Registration</title>
</head>
<body>
	<h2>List Registration</h2>
	<table>
	<thead>
	<tr>
	<th>Name</th>
	<th>City</th>
	<th>Email</th>
	<th>Mobile</th>
	<th>Delete</th>
	<th>Update</th>
	</tr>
	</thead>
	<%
	ResultSet res= (ResultSet)request.getAttribute("result");
	while(res.next()){%>
		<tbody>
		<tr>
		<td><%=res.getString(1)%></td>
		<td><%=res.getString(2)%></td>
		<td><%=res.getString(3)%></td>
		<td><%=res.getString(4)%></td>
		<td><a href="delete?email=<%=res.getString(3)%>">delete</a></td>
		<td><a href="update?email=<%=res.getString(3)%>&mobile=<%=res.getString(4)%>">update</a></td>
		</tr>
		</tbody>
	<%}%>
	</table>
</body>
</html>