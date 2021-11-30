package com.emergentes.controlador;

import com.emergentes.DAO.PadreDAO;
import com.emergentes.DAO.PadreDAOimpl;
import com.emergentes.modelo.Padre;
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
@WebServlet(name = "PadreControlador", urlPatterns = {"/PadreControlador"})
public class PadreControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Padre pad = new Padre();

            int id_padre;
            PadreDAO dao = new PadreDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("pad", pad);
                    request.getRequestDispatcher("frmpadre.jsp").forward(request, response);
                    break;
                case "edit":
                    id_padre = Integer.parseInt(request.getParameter("id_padre"));
                    pad = dao.getById(id_padre);
                    request.setAttribute("pad_ed", pad);
                    request.getRequestDispatcher("frmpadre.jsp").forward(request, response);
                    break;
                case "delete":
                    action = (request.getParameter("action") == "delete") ? request.getParameter("action") : "view";
                    try {
                        id_padre = Integer.parseInt(request.getParameter("id_padre"));
                        dao.delete(id_padre);

                        response.sendRedirect("PadreControlador");

                    } catch (Exception e) {

                        response.sendRedirect("PadreControlador");
                    }
                    break;
                case "view":
                    //obtener la lista de registros
                    List<Padre> pads = dao.getAll();
                    request.setAttribute("pads", pads);

                    request.getRequestDispatcher("padre.jsp").forward(request, response);

                    break;
            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = (request.getParameter("action")!=null) ? request.getParameter("action") : "view";
        PadreDAO dao = new PadreDAOimpl();
        int id_padre = Integer.parseInt(request.getParameter("id_padre"));
        
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");

        Padre pa = new Padre();
        pa.setId_padre(id_padre);
        pa.setNombre(nombre);
        pa.setTelefono(telefono);
        pa.setDirecion(direccion);

        if (id_padre == 0) {
            try {
                dao.insert(pa);
                 action = (request.getParameter("action") == "add") ? request.getParameter("action") : "view";
                response.sendRedirect("PadreControlador");
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        } else {
            try {
                dao.update(pa);
                action = (request.getParameter("action") == "edit") ? request.getParameter("action") : "view";
                response.sendRedirect("PadreControlador");
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        }
    
    }

}
