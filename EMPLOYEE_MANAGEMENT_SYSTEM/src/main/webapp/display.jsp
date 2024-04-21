<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.techpalle.model.Employee" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Page</title>
<style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
        }
        h1 {
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
            color: #333;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
    </style>
</head>
<body>
<h1>Employee Details:</h1>
<table border="1">
	<tr>
		<th>Eno</th>
		<th>Name</th>
		<th>Email</th>
		<th>Password</th>
		<th>Mobile</th>
		<th>Action</th>
	</tr>
	<%

		 ArrayList<Employee> al = (ArrayList<Employee>) request.getAttribute("lst");
		
		for(Employee em : al)
		{
	%>
	
	<tr>
		<td><%= em.getId() %></td>
		<td><%= em.getName() %></td>
		<td><%= em.getEmail() %></td>
		<td><%= em.getPassword() %></td>
		<td><%= em.getMobile() %></td>
		<td>
			<a href="edit?id=<%= em.getId() %>">Edit</a>
			<a href="delete?id=<%= em.getId() %>">Delete</a>
		</td>
	</tr>
	<%
	}
	%>
</table>
</body>
</html>