package com.homeautomation.servlets;

import com.homeautomation.util.DatabaseConnection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/api/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("application/json");

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                response.getWriter().println("{\"message\": \"Login successful!\"}");
            } else {
                response.getWriter().println("{\"message\": \"Invalid credentials.\"}");
            }
        } catch (Exception e) {
            response.getWriter().println("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }
}
