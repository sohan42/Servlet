/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Date;

/**
 *
 * @author Sohan
 */
public class MySession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        //Get the current session if exist else create a new session
        HttpSession session = request.getSession(true);
        //Display date and time of last access
        Date d = (Date)session.getAttribute("date");
        if(d!=null){
            out.println("<h4>Last access: "+d+"</h4>");
        }
        //Display current date and time
        d = new Date();
        session.setAttribute("date", d);
        out.println("<h4>Current access: "+d+"</h4>");
    } 
}
