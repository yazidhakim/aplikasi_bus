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
import models.User;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nitro 5
 */
@WebServlet(name = "UsersController", urlPatterns = {"/users"})
public class UsersController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String auth = request.getParameter("auth");
        if(auth == null){
            request.setAttribute("title","registrasi");
            request.getRequestDispatcher("users/signup.jsp").forward(request, response);
        }else if("login".equals(auth)){
            request.setAttribute("title", "login");
            request.getRequestDispatcher("users/login.jsp").forward(request, response);
        }else if ("logout".equals(auth)) {
            // Perform logout
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("users?auth=login");
        }else if ("view_customer".equals(auth)) {
            // View customer dashboard
            request.setAttribute("title", "Customer Dashboard");
            request.getRequestDispatcher("users/view_customer.jsp").forward(request, response);
        } else {
            // Default case: Redirect to registration
            response.sendRedirect("users");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if("login".equals(action)){
            User user = new User();
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            boolean isValid = user.validate(); 
            
            if(isValid){
                HttpSession session = request.getSession();
                session.setAttribute("user", user);  // Set user ke session
                response.sendRedirect("users?auth=view_customer"); 
                return;
            } else {
                request.getSession().setAttribute("msg", "Login failed! Check your username or password.");
                response.sendRedirect("users?auth=login");
            }
        } else {  // Sign up action
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String role = request.getParameter("role");  // Mendapatkan role dari form
            
            // Membuat objek User dan menyetel parameter
            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            user.setRole(role);
            
            // Menyimpan data user baru
            user.insert();
            
            // Menampilkan pesan sukses dan mengarahkan ke halaman login
            request.getSession().setAttribute("msg", "Signup successful!");
            response.sendRedirect("users?auth=login");  // Mengarahkan ke halaman login setelah signup
        }
    }
}
