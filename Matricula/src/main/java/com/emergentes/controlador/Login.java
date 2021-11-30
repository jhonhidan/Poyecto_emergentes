package com.emergentes.controlador;

import com.emergentes.utilitarios.Vaidate;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //verficar datos 
        String email = request.getParameter("email");
        String password = request.getParameter("password");
      
        Vaidate v = new Vaidate();
        if (v.checkUser(email, password)) {
            System.out.println("Todo ok");
            HttpSession se=request.getSession();
            se.setAttribute("index", "ok");
            response.sendRedirect("home.jsp");
            
        } else {
            response.sendRedirect("index.jsp");
            System.out.println("incorecto");
        }
    }

}
