<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.User"%>
<%@page import="models.City"%>
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
        .booking-section {
            background-color: #fff;
            padding: 20px;
            margin: 20px auto;
            max-width: 100%;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .tabs {
            display: flex;
            margin-bottom: 20px;
        }

        .tab {
            flex: 1;
            padding: 10px;
            text-align: center;
            cursor: pointer;
            border-bottom: 2px solid transparent;
        }

        .tab.active {
            font-weight: bold;
            border-bottom-color: #ffc107;
        }

        .booking-form {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 15px;
        }

        .form-group {
            display: flex;
            flex-direction: column;
        }

        .form-group label {
            margin-bottom: 5px;
            font-size: 14px;
        }

        .form-group input,
        .form-group select {
            padding: 10px;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .search-button {
            padding: 10px;
            background-color: #ffc107;
            color: #000;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            grid-column: span 2;
        }

        .search-button:hover {
            background-color: #e0a800;
        }
        .suggestions {
            border: 1px solid #ccc;
            background: white;
            position: absolute;
            z-index: 1000;
            width: calc(100% - 20px);
            max-height: 200px;
            overflow-y: auto;
            display: none; /* Sembunyikan secara default */
        }
        .suggestion-item {
            padding: 10px;
            cursor: pointer;
        }
        .suggestion-item:hover {
            background-color: #f0f0f0;
        }
        .category {
            font-weight: bold;
            padding: 5px 10px;
            background-color: #f9f9f9;
        }
        /* Responsive Design */
        @media (max-width: 600px) {
            .booking-section {
                margin: 10px;
                padding: 15px;
            }

            .vehicle-images img {
                max-width: 60px;
            }

            .search-button {
                grid-column: span 1;
            }
        }
    </style>
    <script>
        let cities = []; // Menyimpan data kota

        // Fungsi untuk mengambil data kota dari API
        async function fetchCities() {
            try {
                const response = await fetch('/pembayaran/api/city');
                cities = await response.json(); // Simpan data kota ke variabel global
            } catch (error) {
                console.error('Error fetching cities:', error);
            }
        }

        // Fungsi untuk menyaring kota berdasarkan input
        function filterCities(inputId, suggestionsId) {
            const input = document.getElementById(inputId);
            const filter = input.value.toLowerCase();
            const suggestions = document.getElementById(suggestionsId);
            suggestions.innerHTML = ''; // Kosongkan daftar sebelumnya
            suggestions.style.display = 'none'; // Sembunyikan daftar

            if (filter) {
                const popularCities = cities.filter(city => city.name.toLowerCase().includes(filter));
                if (popularCities.length > 0) {
                    suggestions.style.display = 'block'; // Tampilkan daftar
                    suggestions.innerHTML += '<div class="category">KOTA POPULER</div>'; // Tambahkan kategori
                    popularCities.forEach(city => {
                        const item = document.createElement('div');
                        item.className = 'suggestion-item';
                        item.textContent = city.name;
                        item.onclick = () => {
                            input.value = city.name; // Set input value
                            suggestions.style.display = 'none'; // Sembunyikan daftar
                        };
                        suggestions.appendChild(item);
                    });
                }
            }
        }

        // Memanggil fungsi fetchCities saat halaman dimuat
        window.onload = fetchCities;
    </script>
</head>
<body>
    <!-- Header -->
    <header class="header">
        <div class="logo">BussGo</div>
        <nav>
            <a href="routes?action=view_bookings">Pesanan Saya</a>
            <a href="users?auth=logout">Logout</a>
        </nav>
    </header>

    <!-- Main Content -->
    <div class="dashboard">
        <h1>Selamat Datang, <%= user.getUsername() %>!</h1>
        <p>Ini adalah dashboard pelanggan Anda. Silakan pilih layanan kami untuk memulai perjalanan Anda.</p>
        <a href="jadwal?action=view_schedule" class="button">Lihat Jadwal Bus</a>
        <a href="routes?action=book_ticket" class="button">Pesan Tiket</a>
        <a href="routes?action=view_bookings" class="button">Cek Pesanan</a>
    </div>
    <div class="booking-section">
        <form class="booking-form" method="get" action="jadwal">
            <div class="form-group">
                <label for="services">Services</label>
                <select id="services" name="services">
                    <option value="all">All Services</option>
                    <option value="Regular">Regular</option>
                    <option value="Executive">Executive</option>
                </select>
            </div>
        
            <div class="form-group">
                <label for="total-passengers">Total Passengers*</label>
                <input type="number" id="total-passengers" name="total-passengers" value="1" min="1">
            </div>
            <div class="form-group">
                <label for="from">From</label>
                <input type="text" id="from" name="from" placeholder="Enter departure location" oninput="filterCities('from', 'from-suggestions')">
                <div id="from-suggestions" class="suggestions"></div> 
            </div>
        
            <div class="form-group">
                <label for="to">To</label>
                <input type="text" id="to" name="to" placeholder="Enter destination" oninput="filterCities('to', 'to-suggestions')">
                <div id="to-suggestions" class="suggestions"></div> 
            </div>
            <div class="form-group">
                <label for="departure-date">Departure Date</label>
                <input type="date" id="departure-date" name="departure-date">
            </div>
            <button type="submit" class="search-button">Search</button>
        </form>        
    </div>

    <!-- Footer -->
    <footer class="footer">
        &copy; 2024 BussGo. All rights reserved.
    </footer>
</body>
</html>
