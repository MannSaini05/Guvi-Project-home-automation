package com.yourpackage.servlets;

import com.yourpackage.utils.DBConnection;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    // Handle GET request for user profile
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        String userId = request.getParameter("userId"); // Get the user ID from query params

        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT username, email, created_at, status FROM users WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String username = rs.getString("username");
                String email = rs.getString("email");
                String creationDate = rs.getString("created_at");
                String status = rs.getString("status");

                // Set user data as attributes to be accessed by JSP
                request.setAttribute("username", username);
                request.setAttribute("email", email);
                request.setAttribute("creationDate", creationDate);
                request.setAttribute("status", status);

                // Forward the request to the JSP page
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/profile.jsp");
                dispatcher.forward(request, response);
            } else {
                response.getWriter().println("No user found with the given user ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error while fetching profile data.");
        }
    }
}
