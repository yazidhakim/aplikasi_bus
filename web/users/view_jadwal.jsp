<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="models.Jadwal"%>
<%@page import="models.User"%>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("users?auth=login");
        return;
    }

    List<Jadwal> schedules = (List<Jadwal>) request.getAttribute("schedules");
    String from = (String) request.getAttribute("from");
    String to = (String) request.getAttribute("to");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Jadwal</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f8f9fa;
        }

        .header {
            background-color: #003366;
            color: #ffffff;
            padding: 20px;
            text-align: center;
        }

        .container {
            max-width: 900px;
            margin: 20px auto;
            background: #ffffff;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
        }

        .booking-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 20px;
            background-color: #003366;
            color: #ffffff;
        }

        .content {
            padding: 20px;
        }

        .schedule-item {
            border: 1px solid #e0e0e0;
            padding: 15px;
            border-radius: 6px;
            margin-bottom: 10px;
            background: #f9f9f9;
        }

        .no-schedule {
            text-align: center;
            color: #ff0000;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>View Jadwal</h1>
    </div>

    <div class="container">
        <div class="booking-header">
            <div><%= from %> - <%= to %></div> <!-- Tampilkan rute dari dan ke -->
        </div>

        <div class="content">
            <div class="schedule">
                <%
                    if (schedules != null && !schedules.isEmpty()) {
                        for (Jadwal schedule : schedules) {
                %>
                    <div class="schedule-item">
                        <h4>Bus Name: <%= schedule.getBusName() %></h4>
                        <p>Tipe Bus: <%= schedule.getBusType() %></p>
                        <p>Waktu Keberangkatan: <%= schedule.getWaktuKeberangkatan() %></p>
                        <p>Waktu Kedatangan: <%= schedule.getWaktuKedatangan() %></p>
                        <p>Tanggal: <%= schedule.getTanggal() %></p>
                        <p>Kota Asal: <%= schedule.getCityAsal() %></p>
                        <p>Kota Tujuan: <%= schedule.getCityTujuan() %></p>
                        <p>Harga Tiket: Rp <%= schedule.getHargaTiket() %> / seat</p>
                        <button 
                            class="select-button" 
                            data-schedule-id="<%= schedule.getJadwalID() %>" 
                            data-bus-name="<%= schedule.getBusName() %>" 
                            data-departure-time="<%= schedule.getWaktuKeberangkatan() %>" 
                            data-arrival-time="<%= schedule.getWaktuKedatangan() %>" 
                            data-price="<%= schedule.getHargaTiket() %>">
                            Select
                        </button>
                    </div>
                <%
                        }
                    } else {
                %>
                    <p class="no-schedule">Tidak ada jadwal yang ditemukan untuk kriteria tersebut.</p>
                <%
                    }
                %>
            </div>
        </div>
    </div>

    <script>
        document.querySelectorAll('.select-button').forEach(button => {
            button.addEventListener('click', () => {
                const scheduleId = button.getAttribute('data-schedule-id');
                const busName = button.getAttribute('data-bus-name');
                const departureTime = button.getAttribute('data-departure-time');
                const arrivalTime = button.getAttribute('data-arrival-time');
                const price = button.getAttribute('data-price');

                // Arahkan ke view_transaksi.jsp dengan parameter jadwal
                window.location.href = `view_transaksi.jsp?scheduleId=${scheduleId}&busName=${encodeURIComponent(busName)}&departureTime=${encodeURIComponent(departureTime)}&arrivalTime=${encodeURIComponent(arrivalTime)}&price=${price}`;
            });
        });
    </script>
</body>
</html>
