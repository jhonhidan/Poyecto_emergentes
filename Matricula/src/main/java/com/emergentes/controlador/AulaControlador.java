
package com.emergentes.controlador;

import com.emergentes.DAO.AulaDAO;
import com.emergentes.DAO.AulaDAOimpl;
import com.emergentes.modelo.Aula;
import com.emergentes.modelo.Cantidad;
import com.emergentes.utilitarios.Consultas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jhonny
 */
@WebServlet(name = "AulaControlador", urlPatterns = {"/AulaControlador"})
public class AulaControlador extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           try {
            Aula au = new Aula();
           
            
            int id_aula;
            AulaDAO dao = new AulaDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("au",au);
                    request.getRequestDispatcher("frmaula.jsp").forward(request, response);
                    break;
                case "edit":
                    id_aula = Integer.parseInt(request.getParameter("id_aula"));
                    au = dao.getById(id_aula);
                    request.setAttribute("au", au);
                    request.getRequestDispatcher("frmaula.jsp").forward(request, response);
                    break;
                case "delete":
                     action = (request.getParameter("action") == "delete") ? request.getParameter("action") : "view";
                    try {
                        id_aula = Integer.parseInt(request.getParameter("Id_aula"));
                        dao.delete(id_aula);

                         response.sendRedirect("AulaControlador");

                    } catch (Exception e) {

                         response.sendRedirect("AulaControlador");
                    }
                    break;
                case "view":

               
                     // List<Cantidad> cantid = dao.getAll_cant();
                    //request.setAttribute("cantid",cantid);
                 
                 
                    List<Aula> aula = dao.getAll();
                    request.setAttribute("aul", aula);

                    request.getRequestDispatcher("aula.jsp").forward(request, response);

                    break;
            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        AulaDAO dao = new AulaDAOimpl();
        int Id_aula =Integer.parseInt(request.getParameter("Id_aula"));
        String descripcion_aula=request.getParameter("descripcion_aula");
        String estado_aula=request.getParameter("estado_aula");
        Aula au = new Aula();
        au.setId_aula(Id_aula);
        au.setDescripcion_aula(descripcion_aula);
        au.setEstado_aula(estado_aula);
      

        if (Id_aula == 0) {
            try {
                dao.insert(au);
                ///action = (request.getParameter("action") == "add") ? request.getParameter("action") : "view";
                response.sendRedirect("AulaControlador");
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        } else {
            try {
                dao.update(au);
                //action = (request.getParameter("action") == "edit") ? request.getParameter("action") : "view";
                response.sendRedirect("AulaControlador");
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        }

        
        
        
         
    }

  
}
