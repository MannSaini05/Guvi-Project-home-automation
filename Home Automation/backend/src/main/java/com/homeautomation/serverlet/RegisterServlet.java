package com.homeautomation.servlets;

import com.homeautomation.util.DatabaseConnection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/api/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        response.setContentType("application/json");

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, email);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                response.getWriter().println("{\"message\": \"User registered successfully!\"}");
            } else {
                response.getWriter().println("{\"message\": \"Registration failed.\"}");
            }
        } catch (Exception e) {
            response.getWriter().println("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }
}
