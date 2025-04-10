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
import java.sql.*;

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
        out.println("</head><body>");
        out.println("<form method='post' action='/MyWebApp/Servlet3'>");
        out.println("Username: <input type='text' name='username' required><br>");
        out.println("Password: <input type='password' name='password' required><br>");
        out.println("<input type='submit' value='Submit'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String un = request.getParameter("username");
        String ps = request.getParameter("password");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = Database.connect();
            
            String sql = "SELECT * FROM login WHERE username=? AND password=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, un);
            stmt.setString(2, ps);
            ResultSet rs = stmt.executeQuery();

            response.setContentType("text/html");
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Login Result</title>");
            out.println("<link rel='stylesheet' type='text/css' href='css/style.css'>");
            out.println("</head><body>");

            if (rs.next()) {
                out.println("<h2>Login Successful! Welcome, " + un + ".</h2>");
            } else {
                out.println("<h2>Invalid Credentials! Try Again.</h2>");
                out.println("<a href='Servlet3'>Back to Login</a>");
            }

            out.println("</body></html>");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h2>Error connecting to the database!</h2>");
        }
    }
}

