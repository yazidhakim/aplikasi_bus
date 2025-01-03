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

/**
 *
 * @author Nitro 5
 */
@WebServlet(name = "PemesananController", urlPatterns = {"/pemesanan"})
public class PemesananController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Ambil data dari parameter URL
        String userId = request.getParameter("userId");
        String scheduleId = request.getParameter("scheduleId");
        String busName = request.getParameter("busName");
        String departureTime = request.getParameter("departureTime");
        String arrivalTime = request.getParameter("arrivalTime");
        String price = request.getParameter("price");

        // Menyimpan parameter ke dalam request untuk digunakan di view_pemesanan.jsp
        request.setAttribute("userId", userId);
        request.setAttribute("scheduleId", scheduleId);
        request.setAttribute("busName", busName);
        request.setAttribute("departureTime", departureTime);
        request.setAttribute("arrivalTime", arrivalTime);
        request.setAttribute("price", price);

        // Arahkan ke view_pemesanan.jsp
        request.getRequestDispatcher("/users/view_transaksi.jsp").forward(request, response);
    }
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
        return "Short description";
    }// </editor-fold>

}
