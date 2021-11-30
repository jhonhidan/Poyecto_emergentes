package com.emergentes.controlador;

import com.emergentes.DAO.LectivoDAO;
import com.emergentes.DAO.LectivoDAOimpl;

import com.emergentes.DAO.SeccionDAO;
import com.emergentes.DAO.SeccionDAOimpl;

import com.emergentes.modelo.Lectivo;
import com.emergentes.modelo.Seccion;
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
@WebServlet(name = "SeccionControlador", urlPatterns = {"/SeccionControlador"})
public class SeccionControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Seccion sec = new Seccion();
            Lectivo lec = new Lectivo();
            
            int id_seccion;

            SeccionDAO dao = new SeccionDAOimpl();
            LectivoDAO daolectivo = new LectivoDAOimpl();
            List<Lectivo> lista_lectivo = null;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    lista_lectivo = daolectivo.getAll();
                    request.setAttribute("lecdes", lista_lectivo);
                    request.setAttribute("secid", sec);
                    request.getRequestDispatcher("frmseccion.jsp").forward(request, response);
                    break;
                case "edit":
                    lista_lectivo = daolectivo.getAll();
                    request.setAttribute("lecdes", lista_lectivo);
                    id_seccion = Integer.parseInt(request.getParameter("id_seccion"));
                    sec = dao.getById(id_seccion);
                    request.setAttribute("secid", sec);
                    request.getRequestDispatcher("frmseccion.jsp").forward(request, response);
                    break;
                case "delete":
                    action = (request.getParameter("action") == "delete") ? request.getParameter("action") : "view";
                    try {
                        id_seccion = Integer.parseInt(request.getParameter("id_seccion"));
                        dao.delete(id_seccion);

                        response.sendRedirect("SeccionControlador");

                    } catch (Exception e) {

                        response.sendRedirect("SeccionControlador");
                    }
                    break;
                case "view":
                    //obtener la lista de registros
                    List<Seccion> se = dao.getAll();
                    request.setAttribute("secs", se);

                    request.getRequestDispatcher("seccion.jsp").forward(request, response);

                    break;
            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        SeccionDAO dao1 = new SeccionDAOimpl();
        int id_seccion = Integer.parseInt(request.getParameter("id_seccion"));
        String descripcion_sec = request.getParameter("descripcion_sec");
        String estado_sec = request.getParameter("estado_sec");
        int id_ano_lectivo = Integer.parseInt(request.getParameter("id_ano_lectivo"));

        Seccion sec = new Seccion();
        sec.setId_seccion(id_seccion);
        sec.setDescripcion_sec(descripcion_sec);
        sec.setEstado_sec(estado_sec);
        sec.setId_ano_lectivo(id_ano_lectivo);

        if (id_seccion == 0) {
            try {
                dao1.insert(sec);
                action = (request.getParameter("action") == "add") ? request.getParameter("action") : "view";
                response.sendRedirect("SeccionControlador");
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        } else {
            try {
                dao1.update(sec);
               action = (request.getParameter("action") == "edit") ? request.getParameter("action") : "view";
                response.sendRedirect("SeccionControlador");
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        }

    }

}
