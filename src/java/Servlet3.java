/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 *
 * @author Sohan
 */
public class Servlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Styled Form</title>");
        out.println("<link rel='stylesheet' type='text/css' href='css/style.css'>");
        response.getWriter().println("</head><body>");
        response.getWriter().println("<form method='post' action='/MyWebApp/Servlet3'>");
        response.getWriter().println("Name: <input type='text' name='name' required><br>");
        response.getWriter().println("Email: <input type='email' name='email' required><br>");
        response.getWriter().println("<input type='submit' value='Submit'>");
        response.getWriter().println("</form>");
        response.getWriter().println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        String name = request.getParameter("name");
        String email = request.getParameter("email");

        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html><head><title>Form Result</title>");
        response.getWriter().println("<link rel='stylesheet' type='text/css' href='css/style.css'>");
        response.getWriter().println("</head><body>");
        response.getWriter().println("<h2>Form Submitted Successfully!</h2>");
        response.getWriter().println("<p>Name: " + name + "</p>");
        response.getWriter().println("<p>Email: " + email + "</p>");
        response.getWriter().println("</body></html>");
    }
}

