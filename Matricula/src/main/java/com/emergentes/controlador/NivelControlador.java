package com.emergentes.controlador;

import com.emergentes.DAO.AulaDAO;
import com.emergentes.DAO.AulaDAOimpl;
import com.emergentes.DAO.NivelDAO;
import com.emergentes.DAO.NivelDAOimpl;
import com.emergentes.DAO.SeccionDAO;
import com.emergentes.DAO.SeccionDAOimpl;
import com.emergentes.modelo.Aula;
import com.emergentes.modelo.Nivel;
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
@WebServlet(name = "NivelControlador", urlPatterns = {"/NivelControlador"})
public class NivelControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //extraccion de tablas  para  seleccion
            Seccion sec = new Seccion();
            SeccionDAO daosec = new SeccionDAOimpl();

            Aula au = new Aula();
            AulaDAO daoaula = new AulaDAOimpl();
            int id_nivel;
            Nivel niv = new Nivel();
            NivelDAO daonivel = new NivelDAOimpl();
            List<Seccion> lista_sec = null;

            List<Aula> lista_aula = null;
            List<Nivel> lista_niv = null;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    //listado de Seccion
                    lista_sec = daosec.getAll();
                    request.setAttribute("lis_sec", lista_sec);
                    //listado de Aula
                    lista_aula = daoaula.getAll();
                    request.setAttribute("lis_aula", lista_aula);
                    //listado de Nivel
                    lista_niv = daonivel.getAll();
                    request.setAttribute("lis_niv", niv);

                    request.getRequestDispatcher("frmnivel.jsp").forward(request, response);
                    break;
                case "edit":
                    //listado de Seccion
                    lista_sec = daosec.getAll();
                    request.setAttribute("lis_sec", lista_sec);
                    //listado de Aula
                    lista_aula = daoaula.getAll();
                    request.setAttribute("lis_aula", lista_aula);
                    id_nivel = Integer.parseInt(request.getParameter("id_nivel"));
                    niv = daonivel.getById(id_nivel);
                    request.setAttribute("lis_edi", niv);
                    request.getRequestDispatcher("frmnivel.jsp").forward(request, response);
                    break;
                case "delete":
                    action = (request.getParameter("action") == "delete") ? request.getParameter("action") : "view";
                    try {
                        id_nivel = Integer.parseInt(request.getParameter("id_nivel"));
                        daonivel.delete(id_nivel);
                        response.sendRedirect("NivelControlador");

                    } catch (Exception e) {
                        response.sendRedirect("NivelControlador");
                    }
                    break;
                case "view":
                    //obtener la lista de registros
                    List<Nivel> nivs = daonivel.getAll();
                    request.setAttribute("lis_niv", nivs);

                    request.getRequestDispatcher("nivel.jsp").forward(request, response);

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
        NivelDAO dao1 = new NivelDAOimpl();
        int Id_nivel = Integer.parseInt(request.getParameter("Id_nivel"));
        String descripcion_niv = request.getParameter("descripcion_niv");
        String fecha_niv = request.getParameter("fecha");
        String estado_niv = request.getParameter("estado_niv");
        int id_seccion = Integer.parseInt(request.getParameter("id_seccion"));
        int id_ula = Integer.parseInt(request.getParameter("id_ula"));

        Nivel niv = new Nivel();
        niv.setId_nivel(Id_nivel);
        niv.setDescripcion_niv(descripcion_niv);
        niv.setFecha_nive(fecha_niv);
        niv.setEstado_niv(estado_niv);
        niv.setId_seccion_niv(id_seccion);
        niv.setId_aula_niv(id_ula);

        if (Id_nivel == 0) {
            try {
                dao1.insert(niv);
                action = (request.getParameter("action") == "add") ? request.getParameter("action") : "view";
                response.sendRedirect("NivelControlador");
            } catch (Exception e) {
                response.sendRedirect("NivelControlador");
                System.out.println("Error" + e.getMessage());
            }
        } else {
            try {
                dao1.update(niv);
                action = (request.getParameter("action") == "edit") ? request.getParameter("action") : "view";
                response.sendRedirect("NivelControlador");
            } catch (Exception e) {
                response.sendRedirect("NivelControlador");
                System.out.println("Error" + e.getMessage());
            }
        }

    }

}
