package controllers;

import models.City;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CityController", urlPatterns = {"/api/city"})
public class CityController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            City cityModel = new City();
            ArrayList<City> cities = cityModel.get(); // Mengambil semua data kota

            // Mengonversi data kota ke format JSON
            StringBuilder json = new StringBuilder();
            json.append("[");
            for (int i = 0; i < cities.size(); i++) {
                City city = cities.get(i);
                json.append("{");
                json.append("\"id\":").append(city.getkotaId()).append(",");
                json.append("\"province_id\":").append(city.getProvinceId()).append(",");
                json.append("\"name\":\"").append(city.getName()).append("\"");
                json.append("}");
                if (i < cities.size() - 1) {
                    json.append(",");
                }
            }
            json.append("]");

            out.print(json.toString()); // Mengirimkan data JSON ke klien
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Implementasi untuk POST jika diperlukan
    }

    @Override
    public String getServletInfo() {
        return "City Controller";
    }
}
