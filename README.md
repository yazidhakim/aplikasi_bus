# 🚌 BussGo - Aplikasi Pemesanan Tiket Bus Online

**BussGo** adalah sebuah aplikasi berbasis web yang dikembangkan menggunakan bahasa pemrograman **Java**, terinspirasi dari layanan seperti **CitiTrans**. Aplikasi ini memfasilitasi proses **registrasi, pemesanan tiket bus antar-kota, dan monitoring data oleh admin**. 
Dalam pengembangannya, BussGo didesain dengan sistem dua peran utama: **Admin** dan **Pengguna (User)**.


## 🔑 Fitur Utama

### 👤 Pengguna (User)
- Registrasi dan login pengguna
- Melihat daftar rute dan jadwal keberangkatan bus
- Memilih lokasi awal, tujuan, jenis bus, dan jadwal keberangkatan
- Melakukan pemesanan tiket
- Melakukan pembayaran (manual / sesuai ketentuan)
- Mendapatkan **resi pembayaran** sebagai bukti pemesanan

### 🛠️ Admin
- Login sebagai admin
- CRUD data:
  - Data bus (nama bus, nomor polisi, kapasitas)
  - Data rute perjalanan (asal, tujuan, estimasi waktu)
  - Jadwal keberangkatan (tanggal, jam, rute, bus)
- Monitoring data pengguna
- Melihat dan mengelola transaksi pemesanan tiket



## 🖥️ Teknologi yang Digunakan
- **Backend:** Java (Servlet/JSP)
- **Frontend:** HTML, CSS
- **Database:** MySQL
- **Fitur Tambahan:** Auto-generate resi/tiket pembayaran

---
## 📌 Struktur Role & Alur Kerja

### Admin Flow:
1. Login ke sistem admin
2. Tambah/edit data bus, rute, dan jadwal
3. Pantau transaksi pengguna secara real-time
4. Dapat mencetak laporan bila diperlukan

### Pengguna Flow:
1. Registrasi akun
2. Login ke sistem
3. Pilih rute, jadwal, dan bus
4. Lakukan pemesanan dan konfirmasi pembayaran
5. Terima resi tiket dan gunakan untuk keberangkatan
6. Riwayat pemesanan setelah melakukan transaksi


## 📦 Rencana Pengembangan (versi Laravel)
Aplikasi ini ke depannya akan dibangun ulang menggunakan **Laravel (PHP)** dengan fitur tambahan:
- Cetak tiket otomatis via **printer thermal (filamen)**
- Integrasi dengan sistem pembayaran digital (QRIS, Midtrans)
- Scan QR Code untuk check-in penumpang
- Dashboard yang lebih modern untuk admin dan pengguna



## 🧑‍💻 Kontributor
- **Yazid Hakim** – Pengembang utama dan perancang sistem BussGo


