<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Homepage</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        /* Header style */
        .header {
            background-color: #003366; /* Biru tua */
            color: white;
            padding: 10px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .header .logo {
            display: flex;
            align-items: center;
        }

        .header .logo img {
            height: 40px; /* Atur tinggi gambar */
            width: 40px; /* Atur lebar gambar sama dengan tinggi untuk lingkaran */
            border-radius: 50%; /* Membuat gambar berbentuk lingkaran */
            object-fit: cover; /* Memastikan gambar tidak terdistorsi */
            margin-right: 10px;
        }

        .header nav {
            display: flex;
            gap: 20px;
        }

        .header nav a {
            color: white;
            text-decoration: none;
            font-size: 16px;
            padding: 5px 10px;
        }

        .header nav a:hover {
            background-color: #00509e; /* Warna biru lebih terang */
            border-radius: 5px;
        }

        /* Main content */
        .main-content {
            padding: 20px;
            text-align: center;
        }

        .main-content h1 {
            font-size: 36px;
            color: #003366;
        }

        .main-content p {
            font-size: 18px;
            color: #555;
        }

        .btn {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            font-size: 16px;
            color: white;
            background-color: #003366;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
        }

        .btn:hover {
            background-color: #00509e;
        }

        .auth-buttons {
            margin-top: 30px;
        }

        .auth-buttons a {
            margin: 0 10px;
            padding: 10px 20px;
            font-size: 16px;
            color: white;
            background-color: #0066cc;
            text-decoration: none;
            border-radius: 5px;
        }

        .auth-buttons a:hover {
            background-color: #004c99;
        }
    </style>
</head>
<body>
    <!-- Header -->
    <header class="header">
        <div class="logo">
            <img src="assets/BussGo.jpg" alt="Logo Aplikasi"> <!-- Tambahkan gambar logo -->
            <span>BussGo</span>
        </div>
        <nav>
            <a href="route.jsp">Rute</a>
            <a href="schedule.jsp">Jadwal</a>
            <a href="booking.jsp">Pemesanan</a>
        </nav>
    </header>

    <!-- Main Content -->
    <div class="main-content">
        <h1>Selamat Datang di BussGo</h1>
        <p>Pilih layanan kami untuk memulai perjalanan Anda dengan mudah dan nyaman.</p>
        <a href="route.jsp" class="btn">Mulai Sekarang</a>

        <!-- Auth Buttons -->
        <div class="auth-buttons">
            <a href="users/signup.jsp">Signup</a>
            <a href="users?auth=login">Login</a>
        </div>
    </div>
</body
