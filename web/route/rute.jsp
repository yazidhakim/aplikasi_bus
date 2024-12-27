<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Manajemen Rute - BussGo</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 60%;
            margin: 40px auto;
            background: #ffffff;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        form {
            margin-top: 20px;
            display: flex;
            flex-direction: column;
            gap: 15px;
        }
        label {
            font-weight: bold;
            color: #555;
        }
        input[type="text"], input[type="number"], select {
            width: 100%;
            padding: 10px;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            padding: 10px;
            font-size: 16px;
            background-color: #007BFF;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Kelola Rute Bus</h1>
        <form action="RuteServlet" method="post">
            <!-- ID Rute -->
            <label for="ruteID">ID Rute:</label>
            <input type="number" id="ruteID" name="ruteID" placeholder="Masukkan ID Rute" required>

            <!-- Bus -->
            <label for="bus">Bus:</label>
            <select id="bus" name="bus" required>
                <option value="" disabled selected>Pilih Bus</option>
                <option value="RegularBus">Regular Bus</option>
                <option value="ExecutiveBus">Executive Bus</option>
            </select>

            <!-- Kota Asal -->
            <label for="kotaAsal">Kota Asal:</label>
            <input type="text" id="kotaAsal" name="kotaAsal" placeholder="Masukkan Kota Asal" required>

            <!-- Kota Akhir -->
            <label for="kotaAkhir">Kota Akhir:</label>
            <input type="text" id="kotaAkhir" name="kotaAkhir" placeholder="Masukkan Kota Akhir" required>

            <!-- Pemberhentian -->
            <label for="pemberhentian">Pemberhentian:</label>
            <input type="text" id="pemberhentian" name="pemberhentian" placeholder="Masukkan Pemberhentian (pisahkan dengan koma)" required>

            <!-- Submit Button -->
            <button type="submit">Simpan Rute</button>
        </form>
    </div>
</body>
</html>

