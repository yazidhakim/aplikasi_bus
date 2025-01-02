

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

        .steps {
            display: flex;
            gap: 15px;
        }

        .step {
            color: #cfd8dc;
        }

        .step.active {
            color: #ffffff;
        }

        .content {
            padding: 20px;
        }

        .schedule {
            margin-bottom: 20px;
        }

        .schedule-item {
            display: flex;
            justify-content: space-between;
            align-items: center;
            border: 1px solid #e0e0e0;
            padding: 15px;
            border-radius: 6px;
            margin-bottom: 10px;
            background: #f9f9f9;
        }

        .schedule-item:hover {
            background: #e0f7fa;
        }

        .details {
            flex: 1;
        }

        .details h4 {
            margin: 0 0 5px;
            font-size: 16px;
            color: #003366;
        }

        .details p {
            margin: 0;
            font-size: 14px;
            color: #757575;
        }

        .price {
            font-size: 16px;
            font-weight: 700;
            color: #003366;
        }

        .select-button {
            padding: 10px 20px;
            background: #003366;
            color: #ffffff;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .select-button:hover {
            background: #00509e;
        }

        .bus-type {
            margin-bottom: 10px;
            font-size: 14px;
            color: #4caf50;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>View Jadwal</h1>
    </div>

    <div class="container">
        <div class="booking-header">
            <div>Balikpapan - Samarinda</div>
            <div class="steps">
                <span class="step active">1. Book</span>
                <span class="step">2. Review</span>
                <span class="step">3. Pay</span>
                <span class="step">4. E-ticket</span>
            </div>
        </div>

        <div class="content">
            <div class="schedule">
                <div class="schedule-item">
                    <div class="details">
                        <h4>Executive Shuttle</h4>
                        <p class="bus-type">Executive Class</p>
                        <p>04:00 - 06:25 (2h 25m)</p>
                    </div>
                    <div class="price">Rp 230.000/seat</div>
                    <button class="select-button">Select</button>
                </div>

                <div class="schedule-item">
                    <div class="details">
                        <h4>Standard Shuttle</h4>
                        <p class="bus-type">Standard Class</p>
                        <p>04:30 - 06:55 (2h 25m)</p>
                    </div>
                    <div class="price">Rp 180.000/seat</div>
                    <button class="select-button">Select</button>
                </div>

                <div class="schedule-item">
                    <div class="details">
                        <h4>Executive Shuttle</h4>
                        <p class="bus-type">Executive Class</p>
                        <p>05:00 - 07:25 (2h 25m)</p>
                    </div>
                    <div class="price">Rp 230.000/seat</div>
                    <button class="select-button">Select</button>
                </div>

                <div class="schedule-item">
                    <div class="details">
                        <h4>Standard Shuttle</h4>
                        <p class="bus-type">Standard Class</p>
                        <p>05:30 - 07:55 (2h 25m)</p>
                    </div>
                    <div class="price">Rp 180.000/seat</div>
                    <button class="select-button">Select</button>
                </div>
            </div>
        </div>
    </div>

    <script>
        document.querySelectorAll('.select-button').forEach(button => {
            button.addEventListener('click', () => {
                alert('You selected this schedule!');
            });
        });
    </script>
</body>
</html>
