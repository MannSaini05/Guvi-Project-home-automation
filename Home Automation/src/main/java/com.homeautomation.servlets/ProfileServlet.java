package com.homeautomation.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Fetch user details and forward to profile page
        request.setAttribute("username", "John Doe");
        request.setAttribute("email", "johndoe@example.com");
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Update user profile (placeholder logic)
        String newEmail = request.getParameter("email");
        System.out.println("User email updated to: " + newEmail);
        
        response.sendRedirect("profile.jsp");
    }
}
