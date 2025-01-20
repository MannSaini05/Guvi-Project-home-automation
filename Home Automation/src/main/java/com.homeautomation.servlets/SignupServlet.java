package com.yourpackage.servlets;

import com.yourpackage.utils.DBConnection;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

    // Handle GET requests (if needed)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<html><body><h2>Welcome to Signup Page</h2></body></html>");
    }

    // Handle POST requests for signup (user registration)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        // Get user input from the registration form
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password); // Password should be hashed (using bcrypt or SHA-256) in real apps.

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                out.print("{\"status\":\"success\",\"message\":\"User registered successfully!\"}");
            } else {
                out.print("{\"status\":\"failure\",\"message\":\"User registration failed.\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.print("{\"status\":\"error\",\"message\":\"An error occurred. Please try again.\"}");
        }
    }
}
