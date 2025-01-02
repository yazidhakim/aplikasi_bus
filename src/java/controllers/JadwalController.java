/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import models.Jadwal;

/**
 *
 * @author Nitro 5
 */
@WebServlet(name = "JadwalController", urlPatterns = {"/jadwal"})
public class JadwalController extends HttpServlet {

    private Jadwal jadwal= new Jadwal();

    public List<Jadwal> getJadwalByRuteID(int ruteID) {
        return jadwal.getByRouteID(ruteID);
    }

    public List<Jadwal> getJadwalByFilters(String from, String to, String date, String busType) {
        // Asumsi ada method dalam model Jadwal yang dapat menerima filter
        return jadwal.getByFilters(from, to, date, busType);
    }
}

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet JadwalController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet JadwalController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String date = request.getParameter("departure-date");
        String busType = request.getParameter("services");

        // Ambil data jadwal sesuai dengan filter yang dipilih
        List<Jadwal> schedules = getJadwalByFilters(from, to, date, busType);
        
        // Kirim data jadwal ke JSP untuk ditampilkan
        request.setAttribute("schedules", schedules);
        request.getRequestDispatcher("/users/view_jadwal.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "JadwalController handles bus schedule search functionality.";
    }// </editor-fold>

}
