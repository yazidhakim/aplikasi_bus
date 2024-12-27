<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.User"%>
<%
    // Periksa apakah pengguna sudah login
    User user = (User) session.getAttribute("user");
    if (user != null) {
        response.sendRedirect("users?auth=view_customer"); // Redirect ke view_customer.jsp jika sudah login
        return;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
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
            .error {
                color: red;
                text-align: center;
                margin-bottom: 15px;
            }
        </style>
    </head>
    <body>
        <div class="form-container">
            <h2>Login</h2>
            <% 
            String message = (String) session.getAttribute("msg");
            if (message != null) {
            %>
                <p class="error"><%= message %></p>
                <% session.removeAttribute("msg"); %>
            <% } %>
            <form action="<%= request.getContextPath() %>/users" method="POST">
                <input type="hidden" name="action" value="login">
                <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="text" id="username" name="username" placeholder="Username" required>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" placeholder="Password" required>
                </div>
                <button type="submit" class="button">Login</button>
            </form>
            <div class="register-link">
                <p>Don't have an account? <a href="users?auth=signup">Register here</a></p>
            </div>
        </div>
    </body>
</html>
