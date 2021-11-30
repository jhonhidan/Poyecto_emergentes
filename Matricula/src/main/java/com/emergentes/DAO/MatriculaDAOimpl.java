package com.emergentes.DAO;

import com.emergentes.modelo.Matricula;
import com.emergentes.utilitarios.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public class MatriculaDAOimpl extends ConexionDB implements MatriculaDAO {

    @Override
    public void insert(Matricula matricula) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO matricula(id_nivel_mat,id_estudiante,estado,fecha_matricula)value(?,?,?,?)");
            ps.setInt(1, matricula.getId_nivel_mat());
            ps.setInt(2, matricula.getId_estudiante());

            ps.setString(3, matricula.getEstado());
            ps.setString(4, matricula.getFecha_matricula());
           

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }

    }

    @Override
    public void update(Matricula matricula) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE matricula SET id_nivel_mat=?,id_estudiante=?,estado=?,fecha_matricula=? where id_matricula=?");

            ps.setInt(1, matricula.getId_nivel_mat());
            ps.setInt(2, matricula.getId_estudiante());

            ps.setString(3, matricula.getEstado());
            ps.setString(4, matricula.getFecha_matricula());
            ps.setInt(5, matricula.getId_matricula());
            System.out.println(matricula.getId_nivel_mat());
            System.out.println(matricula.getId_estudiante());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id_matricula) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM matricula WHERE id_matricula=?");
            ps.setInt(1, id_matricula);

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public Matricula getById(int id_matricula) throws Exception {
        try {
            Matricula mat = new Matricula();
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT M.*,E.Nombre_es,E.apellidos,E.foto,E.cedula,E.edad,E.fecha_nacimiento,S.descripcion_sec,A.año,O.descripcion_aula,N.descripcion_niv\n"
                    + " FROM matricula M,nivel N,estudiante E,seccion S,año_lectivo A ,aula O\n"
                    + " WHERE M.id_estudiante=E.id_estudiante and M.id_nivel_mat=N.Id_nivel\n"
                    + "and N.id_seccion=S.id_seccion and S.id_ano_lectivo=A.id_añolectivo and N.id_ula=O.Id_aula and id_matricula=?");

            ps.setInt(1, id_matricula);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                mat.setId_matricula(rs.getInt("id_matricula"));
                mat.setId_nivel_mat(rs.getInt("id_nivel_mat"));
                mat.setId_estudiante(rs.getInt("id_estudiante"));
                mat.setEstado(rs.getString("estado"));
                mat.setFecha_matricula(rs.getString("fecha_matricula"));
                mat.setNombre_es(rs.getString("Nombre_es"));
                mat.setApellidos(rs.getString("apellidos"));
                mat.setCedula(rs.getString("cedula"));
                mat.setEdad(rs.getInt("edad"));
                mat.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                mat.setDescripcion_sec(rs.getString("descripcion_sec"));
                mat.setDescripcion_aula(rs.getString("descripcion_aula"));

                mat.setDescripcion_niv(rs.getString("descripcion_niv"));
                mat.setAño(rs.getString("año"));
                mat.setFoto(rs.getString("foto"));

            }
            return mat;
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Matricula> getAll() throws Exception {
        List<Matricula> lista = null;

        try {

            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("SELECT M.*,E.Nombre_es,E.apellidos,E.cedula,E.edad,E.fecha_nacimiento,S.descripcion_sec,A.año,O.descripcion_aula,N.descripcion_niv\n"
                    + " FROM matricula M,nivel N,estudiante E,seccion S,año_lectivo A ,aula O\n"
                    + " WHERE M.id_estudiante=E.id_estudiante and M.id_nivel_mat=N.Id_nivel\n"
                    + "and N.id_seccion=S.id_seccion and S.id_ano_lectivo=A.id_añolectivo and N.id_ula=O.Id_aula");
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Matricula>();
            while (rs.next()) {
                Matricula mat = new Matricula();

                mat.setId_matricula(rs.getInt("id_matricula"));
                mat.setId_nivel_mat(rs.getInt("id_nivel_mat"));
                mat.setId_estudiante(rs.getInt("id_estudiante"));
                mat.setEstado(rs.getString("estado"));
                mat.setFecha_matricula(rs.getString("fecha_matricula"));

                mat.setNombre_es(rs.getString("Nombre_es"));
                mat.setApellidos(rs.getString("apellidos"));
                mat.setCedula(rs.getString("cedula"));
                mat.setEdad(rs.getInt("edad"));
                mat.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                mat.setDescripcion_sec(rs.getString("descripcion_sec"));
                mat.setDescripcion_aula(rs.getString("descripcion_aula"));

                mat.setDescripcion_niv(rs.getString("descripcion_niv"));
                mat.setAño(rs.getString("año"));
                

                lista.add(mat);
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }

}
