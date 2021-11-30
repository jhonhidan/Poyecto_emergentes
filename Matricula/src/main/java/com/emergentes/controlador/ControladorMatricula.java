package com.emergentes.controlador;

import com.emergentes.DAO.EstudianteDAO;
import com.emergentes.DAO.EstudianteDAOimpl;
import com.emergentes.DAO.MatriculaDAO;
import com.emergentes.DAO.MatriculaDAOimpl;
import com.emergentes.DAO.NivelDAO;
import com.emergentes.DAO.NivelDAOimpl;
import com.emergentes.modelo.Estudiante;
import com.emergentes.modelo.Matricula;
import com.emergentes.modelo.Nivel;
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
@WebServlet(name = "ControladorMatricula", urlPatterns = {"/ControladorMatricula"})
public class ControladorMatricula extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Matricula mat = new Matricula();
            MatriculaDAO daomat = new MatriculaDAOimpl();
            Estudiante est = new Estudiante();
            Nivel niv = new Nivel();
            int id_matricula;

            EstudianteDAO daoest = new EstudianteDAOimpl();
            NivelDAO daonivel = new NivelDAOimpl();
            List<Nivel> lista_nivel = null;
            List<Estudiante> lista_estu = null;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    lista_nivel = daonivel.getAll();
                    request.setAttribute("niv", lista_nivel);
                    lista_estu = daoest.getAll();
                    request.setAttribute("est", lista_estu);
                    request.setAttribute("mat", mat);
                    request.getRequestDispatcher("frmmatricula.jsp").forward(request, response);
                    break;
                case "edit":
                    lista_nivel = daonivel.getAll();
                    request.setAttribute("niv", lista_nivel);
                    lista_estu = daoest.getAll();
                    request.setAttribute("est", lista_estu);
                    id_matricula = Integer.parseInt(request.getParameter("id_matricula"));
                    mat = daomat.getById(id_matricula);
                    request.setAttribute("mat", mat);
                    request.getRequestDispatcher("frmmatricula.jsp").forward(request, response);
                    break;
                case "delete":
                    
                    action = (request.getParameter("action") == "delete") ? request.getParameter("action") : "view";
                    try {
                        id_matricula = Integer.parseInt(request.getParameter("id_matricula"));
                        daomat.delete(id_matricula);

                          response.sendRedirect("ControladorMatricula");

                    } catch (Exception e) {

                         response.sendRedirect("ControladorMatricula");
                    }

                    break;
                case "view":
                    //obtener la lista de registros
                    List<Matricula> mats = daomat.getAll();
                    request.setAttribute("mats", mats);

                    request.getRequestDispatcher("matricula.jsp").forward(request, response);

                    break;
                case "impri":
                    lista_nivel = daonivel.getAll();
                    request.setAttribute("niv", lista_nivel);
                    lista_estu = daoest.getAll();
                    request.setAttribute("est", lista_estu);
                    id_matricula = Integer.parseInt(request.getParameter("id_matricula"));
                    mat = daomat.getById(id_matricula);
                    request.setAttribute("mat", mat);
                    request.getRequestDispatcher("impresion_mat.jsp").forward(request, response);
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
        MatriculaDAO dao1 = new MatriculaDAOimpl();
        int id_matricula = Integer.parseInt(request.getParameter("id_matricula"));
        int id_nivel_mat = Integer.parseInt(request.getParameter("id_nivel_mat"));
        int id_estudiante = Integer.parseInt(request.getParameter("id_estudiante"));
        String estado = request.getParameter("estado");
        String fecha_matricula = request.getParameter("fecha_matricula");
        System.out.println(id_matricula);
        System.out.println(id_nivel_mat);
        System.out.println(id_estudiante);
        System.out.println(estado);
        System.out.println(fecha_matricula);
        Matricula mat = new Matricula();
        mat.setId_matricula(id_matricula);
        mat.setId_nivel_mat(id_nivel_mat);
        mat.setId_estudiante(id_estudiante);
        mat.setEstado(estado);
        mat.setFecha_matricula(fecha_matricula);

        if (id_matricula == 0) {
            try {
                dao1.insert(mat);
                //action = (request.getParameter("action") == "add") ? request.getParameter("action") : "view";
                response.sendRedirect("ControladorMatricula");
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        } else {
            try {
                dao1.update(mat);
                //action = (request.getParameter("action") == "edit") ? request.getParameter("action") : "view";
                response.sendRedirect("ControladorMatricula");
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        }

    }

}
