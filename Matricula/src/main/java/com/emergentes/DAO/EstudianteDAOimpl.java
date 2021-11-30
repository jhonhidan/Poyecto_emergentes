package com.emergentes.DAO;

import com.emergentes.modelo.Estudiante;
import com.emergentes.utilitarios.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAOimpl extends ConexionDB implements EstudianteDAO {

    @Override
    public void insert(Estudiante estudiante) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO estudiante(Nombre_es,apellidos,cedula,edad,fecha_nacimiento,genero,estado_estu,id_padre,foto,correo_estu)value(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, estudiante.getNombre_es());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getCedula());
            ps.setInt(4, estudiante.getEdad());
            ps.setString(5, estudiante.getFecha_naciemto());
            ps.setString(6, estudiante.getGenero());
            ps.setString(7, estudiante.getEstado_estu());
            ps.setInt(8, estudiante.getId_padre());
            ps.setString(9, estudiante.getFoto());
            ps.setString(10, estudiante.getCorreo_estu());
            System.out.println(estudiante.getNombre_es());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Estudiante estudiante) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE estudiante SET Nombre_es=?,apellidos=?,cedula=?,edad=?,fecha_nacimiento=?,genero=?,estado_estu=?,id_padre=?,foto=?,correo_estu=? where id_estudiante=?");
            ps.setString(1, estudiante.getNombre_es());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getCedula());
            ps.setInt(4, estudiante.getEdad());
            ps.setString(5, estudiante.getFecha_naciemto());
            ps.setString(6, estudiante.getGenero());
            ps.setString(7, estudiante.getEstado_estu());
            ps.setInt(8, estudiante.getId_padre());
            ps.setString(9, estudiante.getFoto());
            ps.setString(10, estudiante.getCorreo_estu());
            ps.setInt(11, estudiante.getId_estudiante());
      

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }

    }

    @Override
    public void delete(int id_estudiante) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM estudiante WHERE id_estudiante=?");
            ps.setInt(1, id_estudiante);

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }

    }

    @Override
    public Estudiante getById(int id_estudiante) throws Exception {
        try {
            Estudiante est = new Estudiante();
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM estudiante WHERE id_estudiante=?");
            ps.setInt(1, id_estudiante);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                est.setId_estudiante(rs.getInt("id_estudiante"));
                est.setNombre_es(rs.getString("Nombre_es"));
                est.setApellido(rs.getString("apellidos"));
                est.setCedula(rs.getString("cedula"));
                est.setEdad(rs.getInt("edad"));
                est.setFecha_naciemto(rs.getString("fecha_nacimiento"));
                est.setGenero(rs.getString("genero"));
                est.setEstado_estu(rs.getString("estado_estu"));
                est.setId_padre(rs.getInt("id_padre"));
                est.setFoto(rs.getString("foto"));
                est.setCorreo_estu(rs.getString("correo_estu"));

            }
            return est;
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

    }

    @Override
    public List<Estudiante> getAll() throws Exception {
        List<Estudiante> lista = null;

        try {

            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM padre P,estudiante E WHERE E.id_padre=P.id_padre");
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Estudiante>();
            while (rs.next()) {
                Estudiante est = new Estudiante();
                est.setId_estudiante(rs.getInt("id_estudiante"));
                est.setNombre_es(rs.getString("Nombre_es"));
                est.setApellido(rs.getString("apellidos"));
                est.setCedula(rs.getString("cedula"));
                est.setEdad(rs.getInt("edad"));
                est.setFecha_naciemto(rs.getString("fecha_nacimiento"));
                est.setGenero(rs.getString("genero"));
                est.setEstado_estu(rs.getString("estado_estu"));
                est.setId_padre(rs.getInt("id_padre"));
                est.setFoto(rs.getString("foto"));
                est.setCorreo_estu(rs.getString("correo_estu"));
                est.setNombre_padre(rs.getString("nombre"));
                lista.add(est);
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
