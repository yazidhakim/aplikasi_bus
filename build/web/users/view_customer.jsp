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
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        /* Header Style */
        .header {
            background-color: #003366; /* Biru tua */
            color: white;
            padding: 15px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .header .logo {
            font-size: 24px;
            font-weight: bold;
        }

        .header nav a {
            color: white;
            text-decoration: none;
            margin: 0 15px;
            font-size: 16px;
        }

        .header nav a:hover {
            text-decoration: underline;
        }

        /* Main Content */
        .dashboard {
            max-width: 1200px;
            margin: 30px auto;
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .dashboard h1 {
            color: #003366;
            margin-bottom: 20px;
        }

        .dashboard p {
            font-size: 18px;
            color: #555;
            margin-bottom: 30px;
        }

        .dashboard a.button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #003366;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-size: 16px;
        }

        .dashboard a.button:hover {
            background-color: #00509e;
        }

        /* Footer */
        .footer {
            background-color: #003366;
            color: white;
            text-align: center;
            padding: 10px;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>
    <!-- Header -->
    <header class="header">
        <div class="logo">BussGo</div>
        <nav>
            <a href="routes?action=view_schedule">Jadwal</a>
            <a href="routes?action=book_ticket">Pemesanan</a>
            <a href="routes?action=view_bookings">Pesanan Saya</a>
            <a href="users?auth=logout">Logout</a>
        </nav>
    </header>

    <!-- Main Content -->
    <div class="dashboard">
        <h1>Selamat Datang, <%= user.getUsername() %>!</h1>
        <p>Ini adalah dashboard pelanggan Anda. Silakan pilih layanan kami untuk memulai perjalanan Anda.</p>
        <a href="routes?action=view_schedule" class="button">Lihat Jadwal Bus</a>
        <a href="routes?action=book_ticket" class="button">Pesan Tiket</a>
        <a href="routes?action=view_bookings" class="button">Cek Pesanan</a>
    </div>

    <!-- Footer -->
    <footer class="footer">
        &copy; 2024 BussGo. All rights reserved.
    </footer>
</body>
</html>
