/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Sohan
 */
public class MyCookies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        
        //create a new cookie
        Cookie c1 = new Cookie("Name", "Ajay");
        c1.setMaxAge(10); //cookie called for 10 sec 
        response.addCookie(c1); //adds the specific cookie to the response
        out.println("<h1> My cookies </h1>");
        
        //Read cookies
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie c:cookies){
                out.println("<h3>Cookie Name: "+c.getName()+"</h3>");
                out.println("<h3>Cookie Value: "+c.getValue()+"</h3>");
            }
        }
        else{
            out.println("<h2>NO cookies found!</h2>");
        }
    }
}
