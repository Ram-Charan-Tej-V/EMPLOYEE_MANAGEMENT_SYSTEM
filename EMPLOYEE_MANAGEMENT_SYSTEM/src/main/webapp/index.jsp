<html>
<body>
<style>
body{
			font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            padding: 20px;
            text-align: center;
        }
        h2 {
            color: #333;
        }
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            max-width: 300px;
            margin: 0 auto;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 4px;
            margin-top: 10px;
            width: 100%;
            display: block;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        input[type="submit"]:last-child {
            margin-top: 20px;
        }
    </style>
<h2>Welcome Admin</h2>
<form action="CRUD" method="post">
<input type="submit" name="Register" value="Register"/><br/>
<input type="submit" name="Show" value="Show All"/>
</form>
</body>
</html>
