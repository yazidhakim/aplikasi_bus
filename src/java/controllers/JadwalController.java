package controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Jadwal;

@WebServlet(name = "JadwalController", urlPatterns = {"/jadwal"})
public class JadwalController extends HttpServlet {

    private Jadwal jadwalModel = new Jadwal(); // Menggunakan model untuk mengambil data

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Ambil parameter dari request
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String date = request.getParameter("departure-date");
        String busType = request.getParameter("services");

        // Log parameter yang diterima
        System.out.println("Received parameters: from=" + from + ", to=" + to + ", date=" + date + ", busType=" + busType);

        // Ambil data jadwal sesuai dengan filter yang dipilih
        List<Jadwal> schedules = jadwalModel.getByFilters(from, to, date, busType);

        // Log hasil jadwal yang ditemukan
        System.out.println("Schedules found: " + schedules);

        // Kirim data jadwal ke JSP untuk ditampilkan
        request.setAttribute("schedules", schedules);
        request.setAttribute("from", from); // Kirim juga parameter asal
        request.setAttribute("to", to);     // Kirim juga parameter tujuan
        request.getRequestDispatcher("/users/view_jadwal.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Jika ada logika untuk POST, tambahkan di sini
    }

    @Override
    public String getServletInfo() {
        return "JadwalController handles bus schedule search functionality.";
    }
}
