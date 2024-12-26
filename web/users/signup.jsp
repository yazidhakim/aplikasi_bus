<%-- 
    Document   : signup
    Created on : 25 Dec 2024, 12.45.16
    Author     : Nitro 5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.User"%>"
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SignUp</title>
        <style>
        body {
            font-family: Poppins, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .form-container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 400px;
        }
        .form-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .button {
            background-color: #0078d4;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
            margin-top: 10px;
        }
        .button:hover {
            background-color: #005bb5;
        }
        .register-link {
            text-align: center;
            margin-top: 15px;
        }
        .register-link a {
            color: #0078d4;
            text-decoration: none;
        }
        .register-link a:hover {
            text-decoration: underline;
        }
    </style>
    </head>
    <body>
        <h1>Signup</h1>
    <form action="<%= request.getContextPath() %>/users" method="POST">
        <input type="hidden" name="action" value="signup">
        <div class="form-group">
            <input type="text" name="username" placeholder="Username" required>
        </div>
        <div class="form-group">
        <input type="email" name="email" placeholder="Email" required>
        </div>
        <div class="form-group">
        <input type="password" name="password" placeholder="Password" required>
        </div>
        <select name="role">
            <option value="customer">Customer</option>
            <option value="admin">Admin</option>
        </select>
        <button type="submit">Sign Up</button>
    </form>
    <p>Already have an account? <a href="users?auth=login">Login here</a></p>
</body>
</html>
