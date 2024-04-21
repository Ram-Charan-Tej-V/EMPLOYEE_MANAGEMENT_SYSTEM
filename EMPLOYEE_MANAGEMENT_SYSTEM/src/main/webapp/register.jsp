<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.techpalle.model.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
        }
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            margin: 0 auto;
        }
        h2 {
            color: #333;
            text-align: center;
        }
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }
          input[type="text"],
        input[type="email"],
        input[type="password"],
        input[type="tel"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 12px 20px;
            cursor: pointer;
            border-radius: 4px;
            width: 100%;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
<body>
<%
	Employee em = (Employee)request.getAttribute("employee");
	if(em == null)
	{
%>		
		<h1>Employee Registration</h1>
		<form action="reg" method="post">
		<div hidden>
			<input type="number" name="tbId"/>
		</div>
			Name: <input type="text" name="tbName"/><br>
			Email: <input type="email" name="tbEmail"/><br>
			Password: <input type="password" name="tbPass"/><br>
			Mobile: <input type="tel" name="tbMobile"/><br>
			<input type="submit" name="btnReg" value="click here"/>
			
<%
	}
	if(em != null)
	{
%>
		<h1>Employee Edit Form</h1>
		<form action="update" method="post">
		<div hidden>
			<input type="number" name="tbId" value="<%= em.getId()%>"/>
		</div>
		
		Name: <input type="text" name="tbName" value="<%= em.getName()%>"/><br>
		Email: <input type="email" name="tbEmail" value="<%= em.getEmail()%>"/><br>
		Password: <input type="password" name="tbPass" value="<%= em.getPassword()%>"/><br>
		Mobile: <input type="tel" name="tbMobile" value="<%= em.getMobile()%>"/><br>
		<input type="submit" name="btnReg" value="click here"/>
<%	
	}
%>
</form>
</body>
</html>