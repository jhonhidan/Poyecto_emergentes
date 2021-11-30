
package com.emergentes.controlador;

import com.emergentes.DAO.RolDAO;
import com.emergentes.DAO.RolDAOimpl;
import com.emergentes.modelo.Rol;
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
@WebServlet(name = "ControladorRol", urlPatterns = {"/ControladorRol"})
public class ControladorRol extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           try {
            Rol ro = new Rol();
            
            int id_rol;
            RolDAO dao = new RolDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("ro", ro);
                    request.getRequestDispatcher("frmrol.jsp").forward(request, response);
                    break;
                case "edit":
                    id_rol = Integer.parseInt(request.getParameter("id_rol"));
                    ro = dao.getById(id_rol);
                    request.setAttribute("ro",ro);
                    request.getRequestDispatcher("frmrol.jsp").forward(request, response);
                    break;
                case "delete":
                     action = (request.getParameter("action") == "delete") ? request.getParameter("action") : "view";
                    try {
                        id_rol = Integer.parseInt(request.getParameter("id_rol"));
                        dao.delete(id_rol);

                         response.sendRedirect("ControladorRol");

                    } catch (Exception e) {

                        response.sendRedirect("ControladorRol");
                    }
                    break;
                case "view":
                    //obtener la lista de registros
                    List<Rol> roles = dao.getAll();
                    request.setAttribute("roles", roles);

                    request.getRequestDispatcher("rol.jsp").forward(request, response);

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
        RolDAO dao = new RolDAOimpl();
        int id_rol =Integer.parseInt(request.getParameter("id_rol"));
        String descripcion_rol = request.getParameter("descripcion_rol");

        Rol rol = new Rol();
        rol.setId_rol(id_rol);
        rol.setDescripcion_rol(descripcion_rol);
        if (id_rol == 0) {
            try {
                dao.insert(rol);
                ///action = (request.getParameter("action") == "add") ? request.getParameter("action") : "view";
                response.sendRedirect("ControladorRol");
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        } else {
            try {
                dao.update(rol);
                //action = (request.getParameter("action") == "edit") ? request.getParameter("action") : "view";
                 response.sendRedirect("ControladorRol");
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        }
       
    }

}
