package com.emergentes.controlador;

import com.emergentes.DAO.LectivoDAO;
import com.emergentes.DAO.LectivoDAOimpl;
import com.emergentes.modelo.Lectivo;
import java.io.IOException;
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
@WebServlet(name = "LectivoControlador", urlPatterns = {"/LectivoControlador"})
public class LectivoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Lectivo lec = new Lectivo();

            int id_añolectivo;
            LectivoDAO dao = new LectivoDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("lecid", lec);
                    request.getRequestDispatcher("frmlectivo.jsp").forward(request, response);
                    break;
                case "edit":
                    id_añolectivo = Integer.parseInt(request.getParameter("id_añolectivo"));
                    lec = dao.getById(id_añolectivo);
                    request.setAttribute("lecid", lec);
                    request.getRequestDispatcher("frmlectivo.jsp").forward(request, response);
                    break;
                case "delete":
                    action = (request.getParameter("action") == "delete") ? request.getParameter("action") : "view";
                    try {
                        id_añolectivo = Integer.parseInt(request.getParameter("id_añolectivo"));
                        dao.delete(id_añolectivo);

                        response.sendRedirect("LectivoControlador");

                    } catch (Exception e) {

                        response.sendRedirect("LectivoControlador");
                    }
                    break;
                case "view":
                    //obtener la lista de registros
                    List<Lectivo> lis = dao.getAll();
                    request.setAttribute("lec", lis);

                    request.getRequestDispatcher("lectivo.jsp").forward(request, response);

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
        LectivoDAO dao = new LectivoDAOimpl();
        int id_lectivo =Integer.parseInt(request.getParameter("id_anolectivo"));
        String año_inicio = request.getParameter("ano_inicio");
        String año_fin = request.getParameter("ano_fin");
        String estado_año = request.getParameter("estado_ano");
        String año = request.getParameter("ano");

        Lectivo lec = new Lectivo();
        lec.setId_añolectivo(id_lectivo);
        lec.setAño_inicio(año_inicio);
        lec.setAño_fin(año_fin);
        lec.setEstado_año((estado_año));
        lec.setAño(año);

        if (id_lectivo == 0) {
            try {
                dao.insert(lec);
                ///action = (request.getParameter("action") == "add") ? request.getParameter("action") : "view";
                response.sendRedirect("LectivoControlador");
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        } else {
            try {
                dao.update(lec);
                //action = (request.getParameter("action") == "edit") ? request.getParameter("action") : "view";
                response.sendRedirect("LectivoControlador");
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        }

    }

   

}
