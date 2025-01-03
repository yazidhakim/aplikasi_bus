<%-- 
    Document   : view_transaksi
    Created on : 31 Dec 2024, 13.08.28
    Author     : Nitro 5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Transaksi</title>
    <style>
        /* Reset margin dan padding */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        /* Style halaman utama */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh; /* Tinggi penuh viewport */
        }

        /* Container utama */
        .container {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            width: 100%;
            padding: 20px;
        }

        /* Judul dan teks shuttle */
        .shuttle-title {
            font-size: 20px;
            font-weight: bold;
            margin-bottom: 10px;
            color: #002d72; /* Biru tua */
        }

        .shuttle-info {
            margin-bottom: 20px;
            font-size: 14px;
            color: #555;
        }

        /* Garis pemisah */
        .separator {
            border: none;
            border-top: 1px solid #ddd;
            margin: 20px 0;
        }

        /* Form passenger details */
        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-size: 14px;
            color: #333;
        }

        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 14px;
        }

        /* Tombol next */
        .btn-next {
            background-color: #002d72; /* Biru tua */
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 15px;
            font-size: 16px;
            cursor: pointer;
            width: 100%;
        }

        .btn-next:hover {
            background-color: #00509e; /* Biru lebih terang */
        }
    </style>
</head>
<body>
    <div class="container">
        <!-- Informasi Shuttle -->
        <div class="shuttle-title"><%= busName %></div>
        <div class="shuttle-info">
            <p><%= departureTime %> - <%= arrivalTime %></p>
            <p>1 seat(s)</p>
            <p>Price: Rp <%= price %>/seat</p>
        </div>
        <hr class="separator">
        
        <!-- Form Passenger Details -->
        <div>
            <h4>Passenger Details</h4>
            <form action="process_transaction.jsp" method="POST">
                <input type="hidden" name="scheduleId" value="<%= scheduleId %>">
                <div class="form-group">
                    <label for="name">Full Name</label>
                    <input type="text" id="name" name="name" placeholder="Enter your full name">
                </div>
                <div class="form-group">
                    <label for="phone">Phone Number</label>
                    <input type="text" id="phone" name="phone" placeholder="Enter your phone number">
                </div>
                <button type="submit" class="btn-next">Next</button>
            </form>
        </div>
    </div>
</body>
</html>

