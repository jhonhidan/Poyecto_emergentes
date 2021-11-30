package com.emergentes.controlador;

import com.emergentes.DAO.EstudianteDAO;
import com.emergentes.DAO.EstudianteDAOimpl;
import com.emergentes.DAO.PadreDAO;
import com.emergentes.DAO.PadreDAOimpl;
import com.emergentes.modelo.Estudiante;
import com.emergentes.modelo.Padre;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EstudianteControlador", urlPatterns = {"/EstudianteControlador"})
public class EstudianteControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Estudiante est = new Estudiante();

            Padre pa = new Padre();
            int id_estudiante;

            EstudianteDAO dao = new EstudianteDAOimpl();
            PadreDAO daopadre = new PadreDAOimpl();
            List<Padre> lista_padre = null;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    lista_padre = daopadre.getAll();
                    request.setAttribute("pad", lista_padre);
                    request.setAttribute("est", est);
                    request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                    break;
                case "edit":
                    lista_padre = daopadre.getAll();
                    request.setAttribute("pad", lista_padre);
                    id_estudiante = Integer.parseInt(request.getParameter("id_estudiante"));
                    est = dao.getById(id_estudiante);
                    request.setAttribute("est", est);
                    request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                    break;
                case "delete":
                     action = (request.getParameter("action") == "delete") ? request.getParameter("action") : "view";
                    try {
                        id_estudiante = Integer.parseInt(request.getParameter("id_estudiante"));
                        dao.delete(id_estudiante);

                        response.sendRedirect("EstudianteControlador");

                    } catch (Exception e) {

                       response.sendRedirect("EstudianteControlador");
                    }
                    break;
                case "view":
                    //obtener la lista de registros
                    List<Estudiante> estu = dao.getAll();
                    request.setAttribute("ests", estu);

                    request.getRequestDispatcher("estudiante.jsp").forward(request, response);

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
        EstudianteDAO dao1 = new EstudianteDAOimpl();
        int id_estudiante = Integer.parseInt(request.getParameter("id_estudiante"));
        System.out.println(id_estudiante);
        String Nombre_es = request.getParameter("nombre_es");
        String apellidos = request.getParameter("apellidos");
        String cedula = request.getParameter("cedula");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String fecha_nacimiento = request.getParameter("fecha_nacimiento");
        String genero = request.getParameter("genero");
        String estado_estu = request.getParameter("estado_estu");
        int id_padre = Integer.parseInt(request.getParameter("id_padre"));
        String foto = request.getParameter("foto");
        String correo_estu = request.getParameter("correo_estu");

        Estudiante pa = new Estudiante();
        pa.setId_estudiante(id_estudiante);
        pa.setNombre_es(Nombre_es);
        pa.setApellido(apellidos);
        pa.setCedula(cedula);
        pa.setEdad(edad);
        pa.setFecha_naciemto(fecha_nacimiento);
        pa.setGenero(genero);
        pa.setEstado_estu(estado_estu);
        pa.setId_padre(id_padre);
        pa.setFoto(foto);
        pa.setCorreo_estu(correo_estu);

        if (id_estudiante == 0) {
            try {
                dao1.insert(pa);
                //action = (request.getParameter("action") == "add") ? request.getParameter("action") : "view";
                response.sendRedirect("EstudianteControlador");
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        } else {
            try {
                dao1.update(pa);
                //action = (request.getParameter("action") == "edit") ? request.getParameter("action") : "view";
                response.sendRedirect("EstudianteControlador");
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        }

    }

}
