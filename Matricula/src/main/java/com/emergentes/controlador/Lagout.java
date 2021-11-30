
package com.emergentes.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jhonny
 */
@WebServlet(name = "Lagout", urlPatterns = {"/Lagout"})
public class Lagout extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession se=request.getSession();
        se.invalidate();
        response.sendRedirect("index.jsp");
        
       
    }

   // @Override
   // protected void doPost(HttpServletRequest request, HttpServletResponse response)
      //      throws ServletException, IOException {
      //  processRequest(request, response);
   // }

  
}
