package com.emergentes.controlador;

import com.emergentes.DAO.EstudianteDAO;
import com.emergentes.DAO.EstudianteDAOimpl;
import com.emergentes.DAO.RolDAO;
import com.emergentes.DAO.RolDAOimpl;
import com.emergentes.DAO.UsuarioDAO;
import com.emergentes.DAO.UsuariosDAOimpl;
import com.emergentes.modelo.Estudiante;
import com.emergentes.modelo.Rol;
import com.emergentes.modelo.Usuarios;
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
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/UsuarioControlador"})
public class UsuarioControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Estudiante estu = new Estudiante();
            EstudianteDAO daoestu = new EstudianteDAOimpl();

            Rol ro = new Rol();
            Usuarios us = new Usuarios();
            int id_usuario;

            RolDAO daorol = new RolDAOimpl();
            UsuarioDAO daousu = new UsuariosDAOimpl();
            List<Rol> lista_rol = null;
            List<Estudiante> lista_estu = null;
            List<Usuarios> lista_usu = null;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    lista_rol = daorol.getAll();
                    request.setAttribute("rol", lista_rol);

                    lista_estu = daoestu.getAll();
                    request.setAttribute("estu", lista_estu);

                    lista_usu = daousu.getAll();
                    request.setAttribute("us_id", us);
                    request.getRequestDispatcher("frmusuario.jsp").forward(request, response);
                    break;
                case "edit":
                    lista_rol = daorol.getAll();
                    request.setAttribute("rol", lista_rol);

                    lista_estu = daoestu.getAll();
                    request.setAttribute("estu", lista_estu);

                    id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
                    us = daousu.getById(id_usuario);
                    request.setAttribute("us_id", us);
                    request.getRequestDispatcher("frmusuario.jsp").forward(request, response);
                    break;
                case "delete":
                    action = (request.getParameter("action") == "delete") ? request.getParameter("action") : "view";
                    try {
                        id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
                        daousu.delete(id_usuario);
                        response.sendRedirect("UsuarioControlador");

                    } catch (Exception e) {
                        response.sendRedirect("UsuarioControlador");
                    }
                    break;
                case "view":
                    //obtener la lista de registros
                    List<Usuarios> s = daousu.getAll();
                    request.setAttribute("uss", s);

                    request.getRequestDispatcher("usuario.jsp").forward(request, response);

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
        UsuarioDAO daousu = new UsuariosDAOimpl();
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        int id_rol_usu = Integer.parseInt(request.getParameter("id_rol_usu"));
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        String estado_usu = request.getParameter("estado_usu");
        int id_estudiante_usu = Integer.parseInt(request.getParameter("id_estudiante_usu"));
        Usuarios us = new Usuarios();
        us.setId_usuario(id_usuario);
        us.setId_rol_usu(id_rol_usu);
        us.setUsuario(usuario);
        us.setPassword(password);
        us.setEstado_usu(estado_usu);
        us.setId_estudiante_usu(id_estudiante_usu);

        if (id_usuario == 0) {
            try {
                daousu.insert(us);
                ///action = (request.getParameter("action") == "add") ? request.getParameter("action") : "view";
                response.sendRedirect("UsuarioControlador");
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        } else {
            try {
                daousu.update(us);
                //action = (request.getParameter("action") == "edit") ? request.getParameter("action") : "view";
                response.sendRedirect("UsuarioControlador");
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        }

    }

}
