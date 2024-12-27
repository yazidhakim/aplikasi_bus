<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.User"%>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("users?auth=login");
        return;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Dashboard</title>
    </head>
    <body>
        <h1>Welcome, <%= user.getUsername() %>!</h1>
        <p>This is your customer dashboard.</p>
        <a href="users?auth=logout">Logout</a>
    </body>
</html>
